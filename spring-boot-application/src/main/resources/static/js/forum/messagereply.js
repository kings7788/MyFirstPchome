$(document).ready(function(){
	
	$(document).on('click','#replyButton',function(){
		var msgData = $('#replyMsg').val();
		var msgNo = $('#thismessageNo').val()
		var data = { msgData : msgData , msgNo : msgNo}
		$.ajax({
			type:"POST",
			url: "/crud/forum/reply" ,
			data: data,
			timeout:60000,
			success:function(data,result){
				var date = new Date(data.replyMsgAdded.postTime);
				
				var cell0 = $('<div>'+
						data.replyMsgAdded.memberid +" 説: "+ data.replyMsgAdded.replymessage+
							  '</div>').addClass('card-body');
				var cell1 = $('<p>'+date+'</p>').attr('style','float:right');
				var cell2 = $('<div></div>').addClass("card-body");
					cell2 = cell2.append(cell0).append(cell1);
					cell3 = $('<div></div>').addClass("card");
					cell3 = cell3.append(cell2);
				
				
				
				
			
				$('#outsidereply').append(cell3);
				
				
			},
			error:function(xhr,status,error){
				console.log("Error:" + e);
			}
		})
	})
	
})