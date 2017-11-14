<style>
.glyphicon {
	margin-right: 5px;
}

.thumbnail {
	margin-bottom: 20px;
	padding: 0px;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	border-radius: 0px;
}

.caption {
	height: 130px
}

.item.list-group-item {
	float: none;
	width: 100%;
	background-color: #fff;
	margin-bottom: 10px;
}

.item.list-group-item:nth-of-type(odd):hover, .item.list-group-item:hover
	{
	background: #428bca;
}

.item.list-group-item .list-group-image {
	margin-right: 10px;
}

.item.list-group-item .thumbnail {
	margin-bottom: 0px;
}

.item.list-group-item .caption {
	padding: 9px 9px 0px 9px;
}

.item.list-group-item:nth-of-type(odd) {
	background: #eeeeee;
}

.item.list-group-item:before, .item.list-group-item:after {
	display: table;
	content: " ";
}

.item.list-group-item img {
	float: left;
}

.item.list-group-item:after {
	clear: both;
}

.list-group-item-text {
	margin: 0 0 11px;
}
</style>
<script src="${js}/angular.js"></script>
<script src="${js}/productsController.js"></script>
<div class="container" ng-app="ShoppingApp"
	ng-controller="AllProductController as pCtrl">
	<!-- Added breadcrumb component -->
	<div class="row">

		<div class="col-lg-12">

			<c:if test="${userClickAllProducts == true}">

				<script>
					window.categoryId = '';
				</script>

				<ol class="breadcrumb">


					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">All Products</li>


				</ol>
			</c:if>


			<c:if test="${userClickCategoryProducts == true}">
				<script>
					window.categoryId = '${category.id}';
				</script>

				<ol class="breadcrumb">


					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">Category</li>
					<li class="active">${category.categoryName}</li>


				</ol>
			</c:if>


		</div>


		<div id="products" class="row list-group" ng-init="fetchAllProducts()">
			<div class="col-md-3">
				<div class="col-md-12">
					<%@include file="./common/sidebar.jsp"%>
				</div>
			</div>
			<div class="col-md-9">
				<div class="item  col-md-4" ng-repeat="product in allProducts">
					<div class="thumbnail">
						<img class="group list-group-image"
							ng-src="${images}/{{product.code}}.jpg"
							ng-class="{'largImage':hovering}" ng-mouseenter="hovering=true"
							ng-mouseleave="hovering=false" style="height: 200px; width: auto"
							alt="" />
						<div class="caption" style="background:rgba(211, 211, 211, 0.18);">
							<h4 class="group inner list-group-item-heading">{{
								product.name }}</h4>
							<p class="group inner list-group-item-text">{{
								product.descritpion }}</p>
							<div class="row">
								<div class="col-xs-12 col-md-4">
									<p class="lead">$ {{ product.unitPrice }}</p>
								</div>
								
								<security:authorize access="hasAuthority('ROLE_USER')">
								<div class="col-xs-12 col-md-4">
									<a href="${contextRoot}/cart/add/{{product.id}}/product"
										class="btn btn-success"> <span
										class="glyphicon glyphicon-shopping-cart"></span></a>
								</div>
								</security:authorize>
								
								<div class="col-xs-12 col-md-4">
									<a href="${contextRoot}/show/{{product.id}}/product"
										class="btn btn-primary"><span
										class="glyphicon glyphicon-eye-open"></span></a> &#160;
								</div>


							</div>
						</div>
					</div>
				</div>
				<!-- <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Product title</h4>
                    <p class="group inner list-group-item-text">
                        Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Product title</h4>
                    <p class="group inner list-group-item-text">
                        Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Product title</h4>
                    <p class="group inner list-group-item-text">
                        Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Product title</h4>
                    <p class="group inner list-group-item-text">
                        Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Product title</h4>
                    <p class="group inner list-group-item-text">
                        Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div> -->
			</div>
		</div>
	</div>