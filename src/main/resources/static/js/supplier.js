$('document').ready(function(){
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(supplier, status){
			$('#txtIdEdit').val(supplier.id);
			$('#txtAddressEdit').val(supplier.address);
			$('#txtCityEdit').val(supplier.city);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#txtDetailsEdit').val(supplier.details);
			$('#txtEmailEdit').val(supplier.email);
			$('#txtMobileEdit').val(supplier.mobile);
			$('#txtNameEdit').val(supplier.name);
			$('#txtPhoneEdit').val(supplier.phone);
			$('#ddlStateEdit').val(supplier.stateid);
			$('#txtWebsiteEdit').val(supplier.website);
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


