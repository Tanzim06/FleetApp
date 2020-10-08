$('document').ready(function() {



	$('table #editButton').on('click',function(event){
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employee, status) {
			$('#txtIdEdit').val(employee.id);
			$('#txtUsernameEdit').val(employee.username);
			$('#ddlTitleEdit').val(employee.title);
			$('#txtInitialsEdit').val(employee.initials);
			$('#txtSSNEdit').val(employee.socialSecurityNumber);
            $('#txtFirstnameEdit').val(employee.firstname);
            $('#txtLastnameEdit').val(employee.lastname);
            $('#txtOthernameEdit').val(employee.othername);
            $('#ddlGenderEdit').val(employee.gender);
            $('#ddlNationalityEdit').val(employee.countryid);
            $('#txtAddressEdit').val(employee.address);
            $('#txtNetWeightEdit').val(employee.netWeight);
            $('#txtCityEdit').val(employee.city);
            $('#txtPhoneEdit').val(employee.phone);
            $('#ddlStateEdit').val(employee.stateid);
            $('#txtMobileEdit').val(employee.mobile);
            $('#ddlMaritalStatusEdit').val(employee.maritalStatus);
            $('#txtEmailEdit').val(employee.email);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
            $('#fupImageEdit').val(employee.photo);

            var dateOfBirth= employee.dateOfBirth.substr(0,10);
            var hireDate= employee.hireDate.substr(0,10);

            $('#txtDateOfBirthEdit').val(dateOfBirth);
            $('#txtHireDateEdit').val(hireDate);
		});			
		$('#editModal').modal();		
	});


	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();

		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href)
		
		$('#deleteModal').modal();		
	});

	$('.table #photoButton').on('click',function(event) {
       event.preventDefault();
       var href = $(this).attr('href');
       $('#photoModal #employeePhoto').attr('src', href);
       $('#photoModal').modal();
    });
});