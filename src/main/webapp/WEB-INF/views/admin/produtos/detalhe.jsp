<%@include file="../header.jsp"%>

<br>
<section id="slider">
	<div class="container">
		<!-- 
		<form role="form" action="${pageContext.request.contextPath}/admin/produtos/salvar" method="post">
			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" class="form-control" id="nome" name="nome"
					placeholder="Informe o nome do produto..." value="${prod.nome}"/>
			</div>
			<div class="form-group">
				<label for="descricao">Descrição</label> 
				<input type="descricao" class="form-control" id="descricao" name="descricao"
					placeholder="Informe a descricao do produto..." value="${prod.descricao}"/>
			</div>
			<div class="form-group">
				<label for="preco">Preço</label> 
				<input type="text" class="form-control" id="preco" name="preco"
					placeholder="Informe o preço do produto..." value="${prod.preco}"/>
			</div>
			
			<div class="form-group">
				<label for="preco">Categoria</label> 
				<select multiple="multiple" class="chosen-select" name="categorias.id" data-placeholder="Selecione uma categoria...">
					<c:forEach items="${categorias}" var="cat">
						<option value="${cat.id}">${cat.nome}</option>
					</c:forEach>
				</select>
			</div>
			
			<input type="hidden" name="id" id="id" value="${prod.id}"/>
			<button type="submit" class="btn btn-primary btn-lg">Salvar</button>
		</form>
		 -->
		 <form:form action="${pageContext.request.contextPath}/admin/produtos/salvar" method="post" commandName="prod">	
			<div class="form-group">
				<label for="nome">Nome</label> 
				<form:input path="nome" cssClass="form-control" placeholder="Informe o nome do produto..."/>
			</div>
			<div class="form-group">
				<label for="descricao">Descrição</label>
				<form:textarea path="descricao" cssClass="form-control" placeholder="Informe a descricao do produto..."/>
			</div>
			<div class="form-group">
				<label for="preco">Preço</label> 
				<form:input path="preco" cssClass="form-control" placeholder="Informe o preço do produto..."/>
			</div>
			
			<div class="form-group">
				<label for="preco">Categoria</label> 
				<form:select multiple="true" path="categorias" data-placeholder="Selecione uma categoria..." cssClass="chosen-select">
				 	<form:options items="${listaCategorias}" itemValue="id" itemLabel="nome"/>
				</form:select>				
			</div>		 	
		 	
		 	<form:hidden path="id"/>
		 	<form:button class="btn btn-primary btn-lg">Salvar</form:button>
		 </form:form>
	</div>
</section>

<%@include file="../footer.jsp"%>