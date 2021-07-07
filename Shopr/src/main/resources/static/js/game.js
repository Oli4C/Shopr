
$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(game, status){

			$('#idEdit').val(game.id);
			$('#typeEdit').val(game.type);
			$('#titleEdit').val(game.title);
			$('#priceEdit').val(game.price);
			$('#supplierIdEdit').val(game.supplierId);
			$('#publisherEdit').val(game.publisher);
			$('#minAgeEdit').val(game.minAge);
			$('#gameGenreEdit').val(game.gameGenre);

		});			
		$('#editModal').modal();		
	});


	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(game, status){
			$('#idDetails').val(game.id);
			$('#typeDetails').val(game.type);
			$('#titleDetails').val(game.title);
			$('#priceDetails').val(game.price);
			$('#supplierIdDetails').val(game.supplierId);
			$('#publisherDetails').val(game.publisher);
			$('#minAgeDetails').val(game.minAge);
			$('#gameGenreDetails').val(game.gameGenre);

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
		$.get(href, function (game, status) {
			console.log(game);
			$('#idOrder').val(game.id);
			$('#gameTitleOrder').val(game.title);
			$('#priceOrder').val(game.price);

		});
		$('#orderModal').modal();
	});
});