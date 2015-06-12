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
	            <th  style="width: 15%;">Preço</th>
	            <th  style="width: 5%;">Ação</th>  
	          </tr>  
	        </thead>  
	        <tbody>  
				<c:forEach items="${produtos}" var="produto">
			          <tr>  
			            <td class="text-left">${produto.id}</td>  
			            <td class="text-left">${produto.nome}</td>
			            <td class="text-left">${produto.descricao}</td>
			            <td class="text-left">${produto.preco}</td>  
			            <td class="text-left"><a href="${pageContext.request.contextPath}/admin/produtos/editar?id=${produto.id}">Editar</a>
			             <td class="text-left"><a href="${pageContext.request.contextPath}/admin/produtos/remover?id=${produto.id}">Remover</a></td>  
			          </tr>				
				</c:forEach>
			</tbody>  
		</table>
		
		<a class="btn btn-primary btn-lg pull-right" href="${pageContext.request.contextPath}/admin/produtos/novo" role="button">Novo Produto</a>

	</div>
</section>
<%@include file="../footer.jsp"%>
