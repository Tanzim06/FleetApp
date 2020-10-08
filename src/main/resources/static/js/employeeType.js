$('document').ready(function() {
	
	$('table #editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employeeType, status){
			$('#idEdit').val(employeeType.id);

			$('#descriptionEdit').val(employeeType.description);
			$('#detailsEdit').val(employeeType.details);
		});			
		$('#editModal').modal();		
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employeeType, status){
			$('#idDetails').val(employeeType.id);
			$('#descriptionDetails').val(employeeType.description);
			$('#detailsDetails').val(employeeType.details);

			$('#createdByDetails').val(employeeType.createdBy);
            $('#createdByDetails').val(employeeType.createdBy);
            $('#createdDateDetails').val(employeeType.createdDate.substr(0,19).replace("T", " "));
            $('#lastModifiedByDetails').val(employeeType.lastModifiedBy);
            $('#lastModifiedDateDetails').val(employeeType.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});


	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href)
		
		$('#deleteModal').modal();		
	});	
});
