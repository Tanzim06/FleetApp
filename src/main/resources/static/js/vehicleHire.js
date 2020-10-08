$('document').ready(function() {



	$('table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHires, status) {
			$('#idEdit').val(vehicleHires.id);
			$('#ddlVehicleEdit').val(vehicleHires.vehicleid);
			$('#ddlClientEdit').val(vehicleHires.clientid);
			$('#timeOutEdit').val(vehicleHires.timeOut);
			$('#timeInEdit').val(vehicleHires.timeIn);
			$('#priceEdit').val(vehicleHires.price);
			$('#remarksEdit').val(vehicleHires.remarks);
            $('#ddlLocationEdit').val(vehicleHires.locationid);

			var dateOut= vehicleHires.dateOut.substr(0,10);
			var dateIn= vehicleHires.dateIn.substr(0,10);

			$('#dateOutEdit').val(vehicleHires.dateOut);
			$('#dateInEdit').val(vehicleHires.dateIn);


		});			
		$('#editModal').modal();		
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleHires, status){
			$('#idDetails').val(vehicleHires.id);
			$('#ddlVehicleDetails').val(vehicleHires.vehicleid);
			$('#date1Details').val(vehicleHires.date1.substr(0,19).replace("T", " "));
			$('#remarksDetails').val(vehicleHires.remarks);
			$('#date2Details').val(vehicleHires.date2.substr(0,19).replace("T", " "));
			$('#ddlLocation1Details').val(vehicleHires.locationid1);
			$('#ddlLocation2Details').val(vehicleHires.locationid2);
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
