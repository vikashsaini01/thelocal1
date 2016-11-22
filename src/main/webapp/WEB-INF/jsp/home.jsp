<%@page import="com.locals.social.FBConnection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Local's</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="tooplate_style.css" rel="stylesheet" type="text/css" />
<!--   Free Website Template by t o o p l a t e . c o m   -->
<link rel="stylesheet" type="text/css"
	href="css/jquery.lightbox-0.5.css" />

<!-- Arquivos utilizados pelo jQuery lightBox plugin -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/jquery.lightbox-0.5.css" media="screen" />
<!-- / fim dos arquivos utilizados pelo jQuery lightBox plugin -->

<!-- Ativando o jQuery lightBox plugin -->
<script type="text/javascript">
	$(function() {
		$('.lightbox').lightBox();
	});
</script>

</head>
<body>
	<div>
		<form:form method="post" modelAttribute="Task" action="/addtask">
			<form:input type="text" path="summary" />
			<form:input type="text" path="description" />
			<form:button type="submit" > Submit </form:button>
		</form:form>
	</div>

	<div id="tooplate_wrapper">
		<div id="tooplate_header">

			<div id="site_title">
				<h1>
					<a href="#">Local's</a>
				</h1>
			</div>

			<div id="tooplate_menu">
				<strong>Welcome "${UserInfo.userName}"
					</li>
			</div>


		</div>
		<!-- end of forever header -->

		<div id="tooplate_main">

			<div id="tooplate_content">

				<h2>Our1 Gallery</h2>
				<p>
					Etiam magna metus, hendrerit non aliquam nec, tincidunt nec metus.
					Sed nec odio vel nulla pellentesque sodales a molestie nisi. Lorem
					ipsum dolor sit amet, consectetur adipiscing elit. Aenean ac leo
					nisi. Nullam lorem enim, rutrum a luctus ut, facilisis ut est.
					Phasellus leo dolor, consequat a posuere a, tincidunt lobortis
					erat. Quisque placerat dapibus condimentum. Validate <a
						href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a>
					and <a href="http://jigsaw.w3.org/css-validator/check/referer"
						rel="nofollow"><strong>CSS</strong></a>.
				</p>

				<div class="cleaner h30"></div>

				<div id="gallery">
					<ul>
						<li><span><a href="#">Project I</a></span> <a
							class="lightbox" href="images/gallery/image_01_l.jpg"
							title="Mauris tincidunt ultricies felis, nec semper ante fringilla ut.">
								<img src="images/gallery/image_01_s.jpg" alt="Image 01" />
						</a></li>

						<li><span><a href="#">Project II</a></span> <a
							class="lightbox" href="images/gallery/image_02_l.jpg"
							title="Nullam dignissim euismod est, in volutpat tellus congue id.">
								<img src="images/gallery/image_02_s.jpg" alt="Image 02" />
						</a></li>

						<li class="lmb"><span><a href="#">Project III</a></span> <a
							class="lightbox" href="images/gallery/image_03_l.jpg"
							title="Proin rutrum facilisis consequat."> <img
								src="images/gallery/image_03_s.jpg" alt="Image 03" />
						</a></li>

						<li><span><a href="#">Project IV</a></span> <a
							class="lightbox" href="images/gallery/image_04_l.jpg"
							title="Phasellus semper nibh sed risus imperdiet faucibus.">
								<img src="images/gallery/image_04_s.jpg" alt="Image 04" />
						</a></li>

						<li><span><a href="#">Project V</a></span> <a
							class="lightbox" href="images/gallery/image_05_l.jpg"
							title="Etiam sodales venenatis ante eget porttitor."> <img
								src="images/gallery/image_05_s.jpg" alt="Image 05" />
						</a></li>

						<li class="lmb"><span><a href="#">Project VI</a></span> <a
							class="lightbox" href="images/gallery/image_06_l.jpg"
							title="Fusce at imperdiet nibh. Curabitur vulputate porta tempus.">
								<img src="images/gallery/image_06_s.jpg" alt="Image 06" />
						</a></li>
					</ul>

					<div class="cleaner"></div>
				</div>

			</div>
			<!-- end of content -->
		</div>
		<!-- end of main -->

		<div id="tooplate_footer">
			Copyright © 2048 <a href="#">Company Name</a> - Designed by <a
				href="http://www.tooplate.com" target="_parent">Website
				Templates</a>
		</div>
		<!-- end of footer -->

	</div>
	<!-- end of wrapper -->
	<!--   Free Website Template by t o o p l a t e . c o m   -->
</body>
</html>