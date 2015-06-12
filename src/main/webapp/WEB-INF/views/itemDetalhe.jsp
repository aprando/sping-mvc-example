<!-- HEADER -->
<%@ include file="header.jsp"%>

				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
								<img src="images/product-details/new.jpg" class="newarrival" alt="" />
								<h2>${item.nome}</h2>
								<p>Web ID: ${item.id}</p>
								<form role="form" action="${pageContext.request.contextPath}/carrinho-compras/adicionar-item" method="get">
									<span>
										<span>${item.preco}</span>
										<label>Quantidade:</label>
										<input type="text" value="1" name="quantidade" />
										<input type="hidden" name="id" value="${item.id}"/>
										<button type="submit" class="btn btn-fefault cart">
											<i class="fa fa-shopping-cart"></i>
											Adicionar ao carrinho
										</button>
									</span>
								</form>
								<p><b>Disponibilidade:</b> In Stock</p>
								<p><b>Condição:</b> New</p>
								<img src="<c:url value='/resources/images/product-details/share.png' />" class="share img-responsive"  alt="" />
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->
	
<%@ include file="footer.jsp"%>

