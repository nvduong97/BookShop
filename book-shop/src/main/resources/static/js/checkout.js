$(document).ready(function() {
$('#btn-submit').click(function() {
			event.preventDefault()

			var userId = $(this).attr("userId");
            id = userId;
            name = $("#fname").val();
            address = $("#fadress").val();
            phone = $("#fphone").val();
			// TODO: Validate thông tin ở đây
			req = {
			     id = id,
                 name = name,
                 address = address,
                 phone = phone;
			}
			console.log(req)
			var myJSON = JSON.stringify(req);
			console.log(myJSON)
			$.ajax({
			   	url: 'http://localhost:8081/api/checkout',
			   	type: 'POST',
			   	data: myJSON,
			   	dataType: "json",
			   	contentType: "application/json; charset=utf-8",
			   	error: function(data) {
			   	    alert("Đã xảy ra lỗi")
			   		alert(data.responseJSON.message)
			   	},
			   	success: function(data) {
                    if(data.success) {
                        alert(data.message)
                        setTimeout(() => location.replace("/account"), 500);
                    } else  {
                        alert(data.message)
                    }
			   	}
			});
		})
		}