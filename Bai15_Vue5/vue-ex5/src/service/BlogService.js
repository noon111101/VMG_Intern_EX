import http from "./http-common";

class BlogService {
  getAll() {
    return http.get("/blogs");
  }

  delete(id) {
    return http.delete(`/tutorials/${id}`);
  }


}

export default new BlogService();