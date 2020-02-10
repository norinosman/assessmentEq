var app = angular.module('app',[]);

app.controller('UserCRUDCtrl', ['$scope','UserCRUDService', function ($scope,UserCRUDService) {
	  
    $scope.updateEmployee = function () {
        UserCRUDService.updateEmployee($scope.employeeNumberEdit,$scope.nameEdit, $scope.emailEdit,$scope.icNumberEdit)
          .then(function success(response){
              $scope.message = 'User data updated!';
              $scope.errorMessage = '';
			  alert('Employee information successfully updated!');
			  location.reload();			  
          },
          function error(response){
              $scope.errorMessage = 'Error updating user!';
              $scope.message = '';
          });
    }

   $scope.addEmployee = function () {
        if ($scope.employeeNumber && $scope.name && $scope.email && $scope.icNumber) {
            UserCRUDService.addEmployee($scope.employeeNumber,$scope.name, $scope.email,$scope.icNumber)
              .then (function success(response){
                  $scope.message = 'Employee added!';
                  $scope.errorMessage = '';
				  if(response.data !='')
				  {
					alert('Employee information successfully added!');
				  }
				  else
				  {
					alert('Employee information unsuccessfully added!  Please ensure EmployeeID has not been assigned to any other employee.');					  
				  }
				  location.reload();
              },
              function error(response){
                  $scope.errorMessage = 'Error adding Employee!';
                  $scope.message = '';
				  alert('Error adding Employee!');
            });
        }
        else {
            $scope.errorMessage = 'Please fill up all required fields!';
            $scope.message = '';
        }
    }
    
    $scope.deleteEmployee = function () {
        UserCRUDService.deleteEmployee()
          .then (function success(response){
              $scope.message = 'Employee deleted!';
              $scope.user = null;
              $scope.errorMessage='';
			  location.reload();
          },
          function error(response){
              $scope.errorMessage = 'Error deleting user!';
              $scope.message='';
          })
    }

	
    $scope.getData = function () {
        UserCRUDService.getAllEmployees()
		 .then(function success(response){ 
			  $scope.employees = response.data;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error getting users!';
          });
    }	

}]);

app.service('UserCRUDService',['$http', function ($http) {
	
    this.addEmployee = function addEmployee(employeeNumber,name, email,icNumber){
        return $http({
          method: 'POST',
          url: 'http://localhost:8083/register/employee',
          data: { employeeNumber:employeeNumber, name:name, email:email, icNumber:icNumber}
        });
    }
		
    this.deleteEmployee = function deleteEmployee(){
		id = document.getElementById('deleteId').value 
        return $http({
          method: 'DELETE',
          url: 'http://localhost:8083/delete/employee/'+id
        })
    }
	
    this.updateEmployee = function updateEmployee(employeeNumberEdit,nameEdit, emailEdit,icNumberEdit){
	
	
		employeeNumberEdit = document.getElementById('employeeNumberEdit').value;
		nameEdit = document.getElementById('nameEdit').value;
		emailEdit = document.getElementById('emailEdit').value;
		icNumberEdit = document.getElementById('icNumberEdit').value;

        return $http({
          method: 'PUT',
          url: 'http://localhost:8083/update/employee',
          data: {employeeNumber:employeeNumberEdit, name:nameEdit, email:emailEdit, icNumber:icNumberEdit}
        })
    }
	
    this.getAllEmployees = function getAllEmployees(){
        return $http({
          method: 'GET',
          url: 'http://localhost:8083/employee/allemployee'
        });
    }
	

}]);

 $(document).on('click', '.delete', function(e) {

    e.preventDefault();
    const id = $(this).data('id');
	document.getElementById('deleteId').value = id;
       
})

$(document).on('click', '.edit', function(e) {

    e.preventDefault();
    const id = $(this).data('id');

	var s = id; 
    var arrStr = s.split(/[:;]/);

	document.getElementById('employeeNumberEdit').value = arrStr[0];
	document.getElementById('nameEdit').value = arrStr[1];
	document.getElementById('emailEdit').value = arrStr[2];
	document.getElementById('icNumberEdit').value = arrStr[3];	
	
})


