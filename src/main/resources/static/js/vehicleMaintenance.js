$('document').ready(function() {



	$('table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status) {
			$('#idEdit').val(vehicleMaintenance.id);
			$('#priceEdit').val(vehicleMaintenance.price);
			$('#remarksEdit').val(vehicleMaintenance.remarks);
			$('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);
			$('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);

			var startDate= vehicleMaintenance.startDate.substr(0,10);
			var endDate= vehicleMaintenance.startDate.substr(0,10);

			$('#startDateEdit').val(vehicleMaintenance.startDate);
			$('#endDateEdit').val(vehicleMaintenance.endDate);


		});			
		$('#editModal').modal();		
	});
	
	$('table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMaintenance, status){
			$('#idDetails').val(vehicleMaintenance.id);
			$('#ddlVehicleDetails').val(vehicleMaintenance.vehicleid);
			$('#startDateDetails').val(vehicleMaintenance.startDate.substr(0,19).replace("T", " "));
			$('#remarksDetails').val(vehicleMaintenance.remarks);
			$('#endDateDetails').val(vehicleMaintenance.endDate.substr(0,19).replace("T", " "));
			$('#ddlSupplierDetails').val(vehicleMaintenance.supplierid);
			$('#priceDetails').val(vehicleMaintenance.price);
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
