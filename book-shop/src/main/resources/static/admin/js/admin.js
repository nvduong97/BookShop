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

    $("#exampleInputFile").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#exampleInputFile")[0].files[0]);
        axios.post("/books/upload", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('.product-main-image').attr('src', res.data.link);
            }
        }, function(err){
            NProgress.done();
        });
    });

    $("#btn-add-new").on("click", function () {
           if($("#focusedinput").val() === "" || $("#inputPassword").val() === "" || $("#smallinput").val()==="") {
                    swal(
                        "You need to fill all values"
                    );
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
        axios.post(linkPost, book).then(function(res){
                    NProgress.done();
                    if(res.data != null) {
                        swal(
                            'Good job!',
                            'OK',
                            'success'
                        ).then(function() {
                            location.reload();
                        });
                    } else {
                        swal(
                            'Error',
                            'fail',
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
});