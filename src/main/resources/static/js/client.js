$('document').ready(function(){
	$('table #editButton').on('click', function(event){
		event.preventDefault();
		var href= $(this).attr('href');
		$.get(href, function(client, status){
			$('#txtIdEdit').val(client.id);
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
			$('#txtEmailEdit').val(client.email);
			$('#txtMobileEdit').val(client.mobile);
			$('#txtNameEdit').val(client.name);
			$('#txtPhoneEdit').val(client.phone);
			$('#ddlStateEdit').val(client.stateid);
			$('#txtWebsiteEdit').val(client.website);
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


