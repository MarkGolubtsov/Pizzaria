import HttpClient from 'app/api/HttpClient';

export class UserService {

    static login(username: string, password: string) {
        return HttpClient.executePostRequest<{ token: string }>('/login', {
            email: username,
            password
        })
    }
}
