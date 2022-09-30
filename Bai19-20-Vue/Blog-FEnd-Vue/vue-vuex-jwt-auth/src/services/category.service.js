import http from "../common/http-common";
import {jsonRequest} from "../common/http-common";
import authHeader from "./auth-header";
class CategoryDataService {
    getAll() {
        return http.get("/category", {headers: authHeader()});
    }
    create(data) {
        let fromData = new FormData(data);
        console.log(fromData);
        return http.post("blog/create", fromData);
    }

    update(id, data) {
        return http.put(`blog/update/${id}`, data);
    }

    delete(data) {
        return jsonRequest.delete("blog/delete", { data: data });
    }

    deleteAll() {
        return http.delete(`/todo`);
    }

    findByTitle(title) {
        return http.get(`/todo?title=${title}`);
    }
}

export default new CategoryDataService();