$(document).ready(function(){
	
	var account = $('#accounthere').val();
	$('#giveaccount').val(account);
	
	
	
//	$('#submitbutton').click(function(event){			
//		event.preventDefault();
//		addmessage();
//	})
//	function addmessage(){
//		var form = $('addmessageform')[0];
//		var data = new FormData(form);
//		$.ajax({
//			type:"POST",
//			cache:false,
//			contentType:false,
//			processData:false,
//			enctype:'multipart/form-data',
//			url:"/forum/addmessage",
//			data:data,
//			timeout:600000,
//			success:function(data){
//				alert("something")
//			}
//		})
//	}
})