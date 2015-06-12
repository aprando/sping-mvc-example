<%@include file="../header.jsp"%>

<br>
<section id="slider">
	<div class="container">
		<form role="form" action="${pageContext.request.contextPath}/admin/categorias/salvar" method="post">
			<div class="form-group">
				<label for="nome">Nome</label> 
				<input type="text" class="form-control" id="nome" name="nome"
					placeholder="Informe o nome da categoria..." value="${cat.nome}"/>
			</div>
			<div class="form-group">
				<label for="descricao">Descrição</label> 
				<input type="descricao" class="form-control" id="descricao" name="descricao"
					placeholder="Informe a descricao da categoria..." value="${cat.descricao}"/>
			</div>
			<div class="form-group">
				<label for="idCategoriaPai">Id Categoria Pai</label> 
				<input type="text" class="form-control" id="idCategoriaPai" name="idCategoriaPai"
					placeholder="Informe a categoria pai..." value="${cat.idCategoriaPai}"/>
			</div>
			<input type="hidden" name="id" id="id" value="${cat.id}"/>
			<button type="submit" class="btn btn-primary btn-lg">Salvar</button>
		</form>
	</div>
</section>
<%@include file="../footer.jsp"%>