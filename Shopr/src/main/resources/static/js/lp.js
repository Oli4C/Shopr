
$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(lp, status){

			$('#idEdit').val(lp.id);
			$('#typeEdit').val(lp.type);
			$('#titleEdit').val(lp.title);
			$('#priceEdit').val(lp.price);
			$('#supplierIdEdit').val(lp.supplierId);
			$('#artistEdit').val(lp.artist);

			$('#lpGenreEdit').val(lp.lpGenre);

		});			
		$('#editModal').modal();		
	});


	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(lp, status){
			$('#idDetails').val(lp.id);
			$('#typeDetails').val(lp.type);
			$('#titleDetails').val(lp.title);
			$('#priceDetails').val(lp.price);
			$('#supplierIdDetails').val(lp.supplierId);
			$('#artistDetails').val(lp.artist);

			$('#lpGenreDetails').val(lp.lpGenre);

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

	$('.table #orderButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (lp, status) {
			console.log(lp);
			$('#idOrder').val(lp.id);
			$('#gameTitleOrder').val(lp.title);
			$('#priceOrder').val(lp.price);

		});
		$('#orderModal').modal();
	});
});