var app = angular.module('ShoppingApp', []);

app.controller('ProductController', function($http) {

	var me = this;

	me.mvProducts = [];
	me.mpProducts = [];

	me.fetchProducts = function() {

		$http.get('/MistletoeMia/json/data/mv/products').then(
				function(response) {
					me.mvProducts = response.data;
				});

		$http.get('/MistletoeMia/json/data/mp/products').then(
				function(response) {
					me.mpProducts = response.data;
				});
	}
});

app.controller('AllProductController', [
		'$scope',
		'$http',
		'$window',
		function($scope, $http, $window) {
			$scope.jsonUrl = "";
			if ($window.categoryId == '') {
				$scope.jsonUrl = $window.contextRoot
						+ '/json/data/all/products';
			} else {
				$scope.jsonUrl = $window.contextRoot + '/json/data/category/'
						+ $window.categoryId + '/products';
			}
			$scope.allProducts = [];
			$scope.fetchAllProducts = function() {
				$http.get($scope.jsonUrl).then(
						function(response) {
							console.log(response.data);
							$scope.allProducts = response.data;
						})
			};
			
			

		} ]);