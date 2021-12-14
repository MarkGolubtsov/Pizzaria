import axios from 'axios';

export class HttpClient {

    static executeGetRequest<T>(url: string): Promise<T> {
        return axios.get(url);
    }
}
