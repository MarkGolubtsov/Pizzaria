import axios, {AxiosRequestConfig} from 'axios';
import {constants} from 'app/constants';
import {ApiError} from 'app/api/ApiError';

const backendUrl = constants.SERVER_URL;

export function axiosErrorInterceptor(error: any) {
    const {data} = error.response;

    if (data?.errors?.length) {
        return Promise.reject(new ApiError(data.errors.join('. ')))
    }

    return Promise.reject(new ApiError());
}

axios.interceptors.response.use(response => response, axiosErrorInterceptor);

/**
 * Class for sending requests to server.
 */
export default class HttpClient {

    public static async executePostRequest<T = any>(url: string, body: any, params: any = null): Promise<T> {
        const response = await axios.post(url, body, HttpClient.getRequestConfig({params}));
        return response.data;
    };

    public static async executePutRequest<T = any>(url: string, body: any, params: any = null): Promise<T> {
        const response = await axios.put(url, body, HttpClient.getRequestConfig({params}));
        return response.data;
    };

    public static async executeDeleteRequest<T = any>(url: string): Promise<T> {
        const response = await axios.delete(url, HttpClient.getRequestConfig({}));
        if (response?.data) {
            response.data = {}
        }
        return response.data;

    };

    public static async executeGetRequest<T = any>(url: string, params: any = null): Promise<T> {
        const response = await axios.get(url, HttpClient.getRequestConfig({params}));
        return response.data;
    };


    private static getRequestConfig(config: AxiosRequestConfig, withAuthorization: boolean = true, repeatableRequest = true) {
        const headers: any = {'Content-Type': 'application/json'};

        const token = localStorage.getItem(constants.TOKEN_STORAGE_KEY);

        if (token && withAuthorization) {
            setAuthorizationHeader(headers, token);
        }

        return {
            baseURL: backendUrl,
            ...config,
            headers: {
                ...headers,
                ...config.headers
            },
            repeatableRequest
        }
    }
}

export function setAuthorizationHeader(headers: any, token: string) {
    headers['Authorization'] = `Bearer ${token}`;
}
