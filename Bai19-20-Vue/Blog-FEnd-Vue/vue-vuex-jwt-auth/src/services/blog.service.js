import http from "../common/http-common";
import {jsonRequest} from "../common/http-common";
import authHeader from "./auth-header";
class BlogDataService {
    getAll(params) {
        return http.get("/blog", {params, headers: authHeader()});
    }

    create(data) {
        let fromData = new FormData(data);
        console.log(fromData);
        return http.post("/create", fromData);
    }

    update(id, data) {
        return http.put(`blog/update/${id}`, data);
    }

    delete(data) {
        return jsonRequest.delete("blog/delete", {headers: authHeader(data)});
    }

}

export default new BlogDataService();