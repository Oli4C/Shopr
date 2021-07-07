
$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(user, status){

			$('#idEdit').val(user.id);
			$('#userNameEdit').val(user.userName);
			$('#passwordEdit').val(user.password);

		});			
		$('#editModal').modal();		
	});


	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(user, status){
			$('#idDetails').val(user.id);
			$('#userNameDetails').val(user.userName);
			$('#passwordDetails').val(user.password);

		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #vehiclePhoto').attr('src', href);
		$('#photoModal').modal();		
	});	
});