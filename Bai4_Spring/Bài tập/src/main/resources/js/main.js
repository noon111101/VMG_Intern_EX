 const saveOrUpdate = document.querySelector('#btnSaveOrUpdate');
    const id = document.querySelector('#id');
    const title = document.querySelector('#title');
    const cover = document.querySelector('#cover');
    const content = document.querySelector('#content');
    function showUpdateModal (blogId, blogTitle, blogCover, blogContent) {
        id.value = blogId;
        title.value = blogTitle;
        cover.value = blogCover;
        content.value = blogContent;
        saveOrUpdate.innerText = "Update";
    }
    function showCreateModal() {
        id.value = "";
        title.value = "";
        cover.value = "";
        content.value = "";
        saveOrUpdate.innerText = "Save";
    }

    //them blog
    saveOrUpdate.addEventListener('click', function (e) {
        e.preventDefault();
        if(saveOrUpdate.innerText == "Save") {
                    createBlog({
                            "title": document.getElementById('title').value,
                            "cover": document.getElementById('cover').value,
                            "content": document.getElementById('content').value,
                        });
        }else if(saveOrUpdate.innerText == "Update") {
                    updateBlog({
                            "id": document.getElementById('id').value,
                            "title": document.getElementById('title').value,
                            "cover": document.getElementById('cover').value,
                            "content": document.getElementById('content').value,
                        });
                }


    });

    function createBlog(data) {
        $.ajax({
            url: 'http://localhost:8080/api/create',
            type: 'POST',
            contentType: "application/json",
            processData: false,
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                    Swal.fire({
                        title: 'Thêm thành công!',
                        icon: "success",
                        showConfirmButton: false,
                        timer: 1500
                    }).then(() => {
                        window.location.href = "http://localhost:8080/index";
                    })
            },
            error: function (error) {
                swal.fire({
                    title: "Lỗi!",
                    text: "Thêm thất bại!",
                    icon: "error",
                });
            }
        });
    }

    function updateBlog(data) {
        $.ajax({
            url: 'http://localhost:8080/api/update',
            type: 'PUT',
            contentType: "application/json",
            processData: false,
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire({
                    title: 'Cập nhật thành công!',
                    icon: "success",
                    showConfirmButton: false,
                    timer: 1500
                }).then(() => {
                    window.location.href = "http://localhost:8080/index";
                })
            },
            error: function (error) {
                swal.fire({
                    title: "Lỗi!",
                    text: "Cập nhật thất bại!",
                    icon: "error",
                });
            }
        });
    }

    ///////////////

    $("#btnDelete").click(function () {
        var ids = $('input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        if(typeof ids === "undefined" || ids.length <= 0) {
            Swal.fire({
                icon: 'error',
                title: 'Checked to blog',
                showConfirmButton: false,
                timer: 1500
            })
        }else {
            deleteBlog(ids);
        }
    });

    function deleteBlog(data) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: 'http://localhost:8080/api/delete',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        swalWithBootstrapButtons.fire({
                            icon: 'success',
                            title: 'Your work has been saved',
                            showConfirmButton: false,
                            timer: 1500
                        }).then(() => {
                            window.location = "http://localhost:8080/index"
                        })

                    },
                    error: function (error) {
                        console.log("error: " + error)
                    }
                });


            } else if (
                /* Read more about handling dismissals below */
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your imaginary file is safe :)',
                    'error'
                )
            }
        })


    }