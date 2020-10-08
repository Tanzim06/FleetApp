$('document').ready(function(){
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(contact, status){

			$('#idEdit').val(contact.id);
			$('#firstnameEdit').val(contact.firstname);
			$('#lastnameEdit').val(contact.lastname);
			$('#phoneEdit').val(contact.phone);
			$('#emailEdit').val(contact.email);
			$('#mobileEdit').val(contact.mobile);
			$('#remarksEdit').val(contact.remarks);

		});
		$('#editModal').modal();

	});


	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href)

		$('#deleteModal').modal();
	});
});


