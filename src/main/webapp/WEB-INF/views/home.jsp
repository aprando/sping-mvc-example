<!-- HEADER -->
<%@ include file="header.jsp"%>
	<c:if test="${ not empty mensagem}">
		<div align="center">
				<table>
				<tr><td>&nbsp;</td></tr>
				<tr><td class="btn btn-default row">${mensagem}</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
				</table>
		</div>
	</c:if>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-9 padding-right" style="width: 100%;">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Vitrine</h2>
						
						<c:forEach items="${vitrine}" var="prod">
						
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
											<div class="productinfo text-center">
												<!-- >img src="resources/images/home/product1.jpg" alt="" / -->
												<h2>${prod.preco}</h2>
												<p>${prod.nome}</p>
												<a href="${pageContext.request.contextPath}/item/detalhe?id=${prod.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Detalhe</a>
											</div>
											<div class="product-overlay">
												<div class="overlay-content">
													<h2>${prod.preco}</h2>
													<p>${prod.nome}</p>													
													<a href="${pageContext.request.contextPath}/item/detalhe?id=${prod.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Detalhe</a>
												</div>
											</div>
									</div>
								</div>
							</div>
		
						</c:forEach>
						
					</div><!--features_items-->

					
				</div>
			</div>
		</div>
	</section>
	
	
	<%@ include file="footer.jsp"%>