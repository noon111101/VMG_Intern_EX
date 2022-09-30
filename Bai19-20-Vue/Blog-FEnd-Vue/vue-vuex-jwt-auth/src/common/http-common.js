import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:8080/api",
    headers: {
        enctype:"multipart/form-data",
        "Content-type": false,
        processData: false,
    }
});