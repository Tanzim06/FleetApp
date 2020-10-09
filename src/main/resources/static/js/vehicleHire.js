$('document').ready(function() {



	$('table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status) {
			$('#idEdit').val(vehicleHire.id);
			$('#ddlVehicleEdit').val(vehicleHire.vehicleid);
			$('#ddlClientEdit').val(vehicleHire.clientid);
			$('#timeOutEdit').val(vehicleHire.timeOut);
			$('#timeInEdit').val(vehicleHire.timeIn);
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);
            $('#ddlLocationEdit').val(vehicleHire.locationid);

			var dateOut= vehicleHire.dateOut.substr(0,10);
			var dateIn= vehicleHire.dateIn.substr(0,10);

			$('#dateOutEdit').val(dateOut);
			$('#dateInEdit').val(dateIn);


		});			
		$('#editModal').modal();		
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHire, status){
			$('#idDetails').val(vehicleHire.id);
            $('#ddlVehicleDetails').val(vehicleHire.vehicleid);
            $('#ddlClientDetails').val(vehicleHire.clientid);
            $('#timeOutDetails').val(vehicleHire.timeOut);
            $('#timeInDetails').val(vehicleHire.timeIn);
            $('#priceDetails').val(vehicleHire.price);
            $('#remarksDetails').val(vehicleHire.remarks);
            $('#ddlLocationDetails').val(vehicleHire.locationid);
           var dateOut= vehicleHire.dateOut.substr(0,10);
           var dateIn= vehicleHire.dateIn.substr(0,10);

           $('#dateOutDetails').val(dateOut);
           $('#dateInDetails').val(dateIn);
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
