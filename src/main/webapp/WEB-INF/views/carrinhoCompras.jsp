<!-- HEADER -->
<%@ include file="header.jsp"%>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}/home/">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="description">item</td>
							<td class="price">Preço</td>
							<td class="quantity">Quantidade</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carrinho.items}" var="i"> 

							<tr>
								<td class="cart_description">
									<h4><a href="${pageContext.request.contextPath}/item/detalhe?id=${i.value.produto.id}">${i.value.produto.nome}</a></h4>
									<p>Web ID: ${i.value.produto.id}</p>
								</td>
								<td class="cart_price">
									<p>${i.value.produto.preco}</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" href="${pageContext.request.contextPath}/carrinho-compras/adicionar-item?id=${i.value.produto.id}&quantidade=1"> + </a>
										<input class="cart_quantity_input" type="text" name="quantity" value="${i.value.quantidade}" autocomplete="off" size="2">
										<a class="cart_quantity_down" href="${pageContext.request.contextPath}/carrinho-compras/remover-item?id=${i.value.produto.id}&quantidade=1"> - </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">${i.value.produto.preco * i.value.quantidade}</p>
								</td>
								<td class="cart_delete">
									<a class="cart_quantity_delete" href="${pageContext.request.contextPath}/carrinho-compras/remover-item?id=${i.value.produto.id}&quantidade=${i.value.quantidade}"><i class="fa fa-times"></i></a>
								</td>
							</tr>
	
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<a class="btn btn-default check_out" href="${pageContext.request.contextPath}/carrinho-compras/finalizar-compra">Finalizar Compra</a>
			
		</div>
		<div>&nbsp;</div>
		
		
	</section> <!--/#cart_items-->

	
<%@ include file="footer.jsp"%>