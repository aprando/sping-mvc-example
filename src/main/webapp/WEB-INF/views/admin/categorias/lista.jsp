<%@include file="../header.jsp"%>
<section id="slider">
	<div class="container">
	
		<c:if test="${not empty message}">
			<span class="label label-success" style="font-size: 14px;">${message}</span>
		</c:if>
	
		<table class="table table-striped table-nonfluid" >  
	        <thead>  
	          <tr>  
	            <th  style="width: 5%;">ID</th>  
	            <th  style="width: 30%;">Nome</th>  
	            <th  style="width: 45%;">Descrição</th>  
	            <th  style="width: 15%;">ID PAI</th>
	            <th  style="width: 5%;">Ação</th>  
	          </tr>  
	        </thead>  
	        <tbody>  
				<c:forEach items="${categorias}" var="cat">
			          <tr>  
			            <td class="text-left">${cat.id}</td>  
			            <td class="text-left">${cat.nome}</td>
			            <td class="text-left">${cat.descricao}</td>
			            <td class="text-left">${cat.idCategoriaPai}</td>  
			            <td class="text-left"><a href="${pageContext.request.contextPath}/admin/categorias/editar?id=${cat.id}">Editar</a>
			             <td class="text-left"><a href="${pageContext.request.contextPath}/admin/categorias/remover?id=${cat.id}">Remover</a></td>  
			          </tr>				
				</c:forEach>
			</tbody>  
		</table>
		
		<a class="btn btn-primary btn-lg pull-right" href="${pageContext.request.contextPath}/admin/categorias/novo" role="button">Nova Categoria</a>

	</div>
</section>
<%@include file="../footer.jsp"%>
