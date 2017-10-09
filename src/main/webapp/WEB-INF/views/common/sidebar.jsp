<p class="lead">Category</p>




<div class="list-group">

	<c:forEach items="${categories}" var="category">
	<div>
			<a href="${contextRoot}/show/category/${category.id}/products" class="list-group" id="a_${category.categoryName}">${category.categoryName}</a>
	
	</div>
	</c:forEach>


	 
</div>