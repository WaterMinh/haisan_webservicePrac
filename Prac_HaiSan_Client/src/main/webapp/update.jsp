<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update title here</title>
</head>
<body>
	<h2>Update Product</h2>

	<form action="Update" method="POST">
		<table border=1>
			<tr>
				<th>Tên</th>
				<td><input type="text" name="id" value="${hs.id}" hidden=""
					readonly="readonly" /> <input type="text" name="ten"
					value="${hs.ten}" required="required" /></td>
			</tr>
			<tr>
				<th>Nhà sản xuất</th>
				<td><input type="text" name="ncc" value="${hs.ncc}" /></td>
			</tr>
			<tr>
				<th>Đơn vị tính</th>
				<td><input type="text" name="dvt" value="${hs.dvt}" /></td>
			</tr>
			<tr>
				<th>Số lượng</th>
				<td><input type="number" name="soluong" value="${hs.soluong}" /></td>
			</tr>
			<tr>
				<th>Gía tiền</th>
				<td><input type="number" name="giatien" value="${hs.giatien}" /></td>
			</tr>
			<tr>
				<th>Tình trạng</th>
				<td><input type="radio" name="tinhtrang"
					value="${hs.tinhtrang}" /></td>
			</tr>
			<tr>
				<th>Anh</th>
				<td><input type="image" name="anh" value="${hs.anh}" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="submit" value="Update" /> <input type="reset"
					value="Reset" /></td>

			</tr>
		</table>
	</form>
	<a href="Home">Back</a>
</body>
</html>