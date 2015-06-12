		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="${pageContext.request.contextPath}/home/" class="active">Home</a></li>
								<c:forEach items="${menu}" var="pai">
									<li class="dropdown"><a href="${pageContext.request.contextPath}/vitrine/categoria?id=${pai.id}">
										${pai.nome}
										<c:if test="${not empty pai.filhos}">
											<i class="fa fa-angle-down"> 
										</c:if>
										</i></a>
										<c:if test="${not empty pai.filhos}">
											<ul role="menu" class="sub-menu">
											<c:forEach items="${pai.filhos}" var="filho">			
												<li><a href="${pageContext.request.contextPath}/vitrine/categoria?id=${filho.id}">${filho.nome}</a></li>
											</c:forEach>
											</ul>
										</c:if>
                                	</li>
								</c:forEach>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div><!--/header-bottom-->
	
			