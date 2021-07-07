
$('document').ready(function() {	
	$('.table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(book, status){

			$('#idEdit').val(book.id);
			$('#typeEdit').val(book.type);
			$('#titleEdit').val(book.title);
			$('#priceEdit').val(book.price);
			$('#supplierIdEdit').val(book.supplierId);
			$('#authorEdit').val(book.author);
			$('#isbnEdit').val(book.isbn);
			$('#pagesEdit').val(book.pages);
			$('#bookGenreEdit').val(book.bookGenre);
			$('#descriptionEdit').val(book.description);

		});			
		$('#editModal').modal();		
	});

	$('.table #editButton2').on('click',function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(book, status){

			$('#idEdit2').val(book.id);
			$('#typeEdit2').val(book.type);
			$('#titleEdit2').val(book.title);
			$('#priceEdit2').val(book.price);
			$('#supplierIdEdit2').val(book.supplierId);
			$('#authorEdit2').val(book.author);
			$('#isbnEdit2').val(book.isbn);
			$('#pagesEdit2').val(book.pages);
			
			$('#bookSubjectEdit').val(book.subject);

		});
		$('#editModal2').modal();
	});


	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');
		$.get(href, function(book, status){

			$('#idDetails').val(book.id);
			$('#typeDetails').val(book.type);
			$('#titleDetails').val(book.title);
			$('#priceDetails').val(book.price);
			$('#supplierIdDetails').val(book.supplierId);
			$('#authorDetails').val(book.author);
			$('#isbnDetails').val(book.isbn);
			$('#pagesDetails').val(book.pages);
			$('#bookGenreDetails').val(book.bookGenre);
			$('#descriptionDetails').val(book.description);

		});			
		$('#detailsModal').modal();		
	});

	$('.table #detailsButton2').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(book, status){

			$('#idDetails2').val(book.id);
			$('#typeDetails2').val(book.type);
			$('#titleDetails2').val(book.title);
			$('#priceDetails2').val(book.price);
			$('#supplierIdDetails2').val(book.supplierId);
			$('#authorDetails2').val(book.author);
			$('#isbnDetails2').val(book.isbn);
			$('#pagesDetails2').val(book.pages);

			$('#bookSubjectDetails').val(book.subject);

		});
		$('#detailsModal2').modal();
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
		$.get(href, function (book, status) {
			console.log(book);
			$('#idOrder').val(book.id);
			$('#titleOrder').val(book.title);
			$('#priceOrder').val(book.price);

		});
		$('#orderModal').modal();
	});

	$('.table #orderButton2').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (book, status) {
			console.log(book);
			$('#idOrder2').val(book.id);
			$('#titleOrder2').val(book.title);
			$('#priceOrder2').val(book.price);

		});
		$('#orderModal2').modal();
	});


});