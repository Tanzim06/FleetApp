$('document').ready(function() {

	$('table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicle, status) {
			$('#txtIdEdit').val(vehicle.id);
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
			$('#txtNameEdit').val(vehicle.name);
			$('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);
            $('#txtDescriptionEdit').val(vehicle.description);
            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#ddlLocationEdit').val(vehicle.locationid);
            $('#txtPowerEdit').val(vehicle.power);
            $('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
            $('#txtNetWeightEdit').val(vehicle.netWeight);
            $('#txtRemarksEdit').val(vehicle.remarks);
            $('#ddlEmployeeEdit').val(vehicle.employeeid);
            $('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
            $('#fupImageEdit').val(vehicle.photo);

            var acquisitionDate= vehicle.acquisitionDate.substr(0,10);
            var registrationDate= vehicle.registrationDate.substr(0,10);

            $('#txtAcquisitionDateEdit').val(vehicle.acquisitionDate);
            $('#txtRegistrationDateEdit').val(vehicle.registrationDate);
		});
		$('#editModal').modal();
	});
	


	$('table #detailsButton').on('click',function(event){
    		event.preventDefault();		
    		var href= $(this).attr('href');		
    		$.get(href, function(vehicle, status) {
    			$('#txtIdDetails').val(vehicle.id);
    			$('#ddlVehicleTypeDetails').val(vehicle.vehicletypeid);
    			$('#txtNameDetails').val(vehicle.name);
    			$('#txtVehicleNumberDetails').val(vehicle.vehicleNumber);
                $('#txtDescriptionDetails').val(vehicle.description);
                $('#ddlVehicleMakeDetails').val(vehicle.vehiclemakeid);
                $('#ddlVehicleModelDetails').val(vehicle.vehiclemodelid);
                $('#ddlLocationDetails').val(vehicle.locationid);
                $('#txtPowerDetails').val(vehicle.power);
                $('#txtFuelCapacityDetails').val(vehicle.fuelCapacity);
                $('#txtNetWeightDetails').val(vehicle.netWeight);
                $('#txtRemarksDetails').val(vehicle.remarks);
                $('#ddlEmployeeDetails').val(vehicle.employeeid);
                $('#ddlVehicleStatusDetails').val(vehicle.vehiclestatusid);
                $('#fupImageDetails').val(vehicle.photo);
    
                var acquisitionDate= vehicle.acquisitionDate.substr(0,10);
                var registrationDate= vehicle.registrationDate.substr(0,10);
    
                $('#txtAcquisitionDateDetails').val(vehicle.acquisitionDate);
                $('#txtRegistrationDateDetails').val(vehicle.registrationDate);
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