$(document).ready(function () {

    var userID;
    var imglink;

    $("#add-user").on("click", function () {
        $('#modal-add-user').modal();
    });

    // Create User
    $("#user-cteate-submit-btn").on("click", function () {
        if ($("#name").val().trim() === '' || $("#amount").val().trim() === '' || $("#price").val().trim() === '' || $("#image").val().trim() === '') {
            new PNotify({
                title: 'Error!',
                text: 'Nhập hết các thứ vào đi bạn êi -_-',
                type: 'error',
                delay: 500
            });
            return;
        }

        var data ={
            name = $('#name').val().trim(),
            amount = $('#amount').val(),
            price = $("#price").val(),
            publisherId = $('#publisher').val(),
            authorId = $('#author').val(),
            image = $('.product-main-image').attr('src')
        }

        axios.post("/api/users", data).then(function (res) {
            if (res.data.success) {
                new PNotify({
                    title: 'Success!',
                    text: res.data.message,
                    type: 'success',
                    delay: 500
                });
                setTimeout(() => location.reload(), 500);
            } else {
                new PNotify({
                    title: 'Error!',
                    text: res.data.message,
                    type: 'error',
                    delay: 500
                });
            }
        });
    });

});


$(document).ready(function() {
    var book = {};

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                // $('#preview-product-img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#image").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#image")[0].files[0]);
        axios.post("/books/upload", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('.product-main-image').attr('src', res.data.data);
            }
        }, function(err){
            NProgress.done();
        });
    });


    $("#new-product").on("click", function () {
        dataProduct = {};
        $('#name').val("");
        $('#amount').val("");
        $("#price").val("");
        $("#publisher").val("");
        $('#author').val(""),;
        $('.product-main-image').attr('src', 'https://www.vietnamprintpack.com/images/default.jpg');
        $("#modal-add-book").modal();
    });

    $(".btn-save-product").on("click", function () {
        if ($("#name").val().trim() === '' || $("#amount").val().trim() === '' || $("#price").val().trim() === '') {
//        if($("name").val() === "" || $("#amount").val() === "" || $("#price").val()==="") {
            swal('Không được để trống thông tin');
            return;
        }

        book.name = $('#focusedinput').val();
        book.amount = $('#inputPassword').val();
        book.price = $("#smallinput").val();
        book.publisherId = $('#selector1').val()
        book.authorId = $('#selector2').val()
        book.image = $('.product-main-image').attr('src');

        NProgress.start();
        var linkPost = "/books";
        axios.post(linkPost, dataProduct).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal( res.data.message);
            }
        }, function(err){
            NProgress.done();
            swal('Đã xảy ra lỗi');
        })
    });


    $("#fileUpdate").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#fileUpdate")[0].files[0]);
        axios.post("/api/upload", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('.product-main-image').attr('src', res.data.data);
            }
        }, function(err){
            NProgress.done();
        });
    });


    $(".btn-edit-product").on("click", function () {
        var product = $(this).attr("prodid");
        prodid = product;
        console.log(product);
        NProgress.start();
        axios.get("/api/products/" + product).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $("#input-product-name-update").val(res.data.data.name);
                $("#input-product-desc-update").val(res.data.data.description);
                $("#input-product-category-update").val(res.data.data.categoryId);
                $("#input-product-price-update").val(res.data.data.price);
                if(res.data.data.images != null) {
                    $('.product-main-image').attr('src', res.data.data.images);
                }
                $("#modal-update-product").modal();
            }else {
                console.log("ahihi");
            }
        }, function(err){
            NProgress.done();
        })
    });

    $("#btn-update-product").on("click", function () {
        dataProduct ={};
        if($("#input-product-name-update").val() === "" || $("#input-product-desc-update").val() === "" || $("#input-product-category-update").val()==="") {
            swal(
                'Error',
                'You need to fill all values',
                'error'
            );
            return;
        }

        dataProduct.name = $('#input-product-name-update').val();
        dataProduct.description = $('#input-product-desc-update').val();
        dataProduct.categoryId = $("#input-product-category-update").val();
        dataProduct.images = $('.product-main-image').attr('src');
        dataProduct.price = $("#input-product-price-update").val();
        NProgress.start();
        var linkPost = "/api/products/" + prodid;
        axios.put(linkPost, dataProduct).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal(
                    'Error',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
            swal(
                'Error',
                'Some error when saving product',
                'error'
            );
        })
    });

    $(".btn-deleteBook").on("click", function () {
        bookId = $(this).attr("bookId");
        NProgress.start();
                var link = "/books/" + id;
                axios.delete(link).then(function (res) {
                    NProgress.done();
                    swal(res.data);
                    setTimeout(() => location.reload(), 500);
                }, function (err) {
                    NProgress.done();
                    swal(res.data);
                })

        })
    });

    $(".btn-delete-product").on("click", function () {
        var id = $(this).attr("prodid");
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true
        }).then(function (result) {
            if (result.value) {
                NProgress.start();
                var linkdelete = "/api/products/" + id;
                axios.delete(linkdelete).then(function (res) {
                    NProgress.done();
                    if (res.data.success) {
                        swal(
                            'Good job!',
                            res.data.message,
                            'success'
                        ).then(function () {
                            location.reload();
                        });
                    } else {
                        swal(
                            'Error',
                            res.data.message,
                            'error'
                        );
                    }
                }, function (err) {
                    NProgress.done();
                    swal(
                        'Error',
                        'Some error when deleting product',
                        'error'
                    );
                })
            }
        })
    });

});