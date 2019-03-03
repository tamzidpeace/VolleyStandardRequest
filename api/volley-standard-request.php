<?php

$username = "root";
$password = "";
$host = "localhost";
$db_name = "user_db";
$con = mysqli_connect($host, $username, $password, $db_name);
$sql = "select * from user_info;";
$result = mysqli_query($con, $sql);
$response = array();


while ($row = mysqli_fetch_array($result)) {
	array_push($response, array("Name" => $row["name"], "Email" => $row["email"], "Mobile" => $row["mobile"]));
}

echo json_encode(array("response2" => $response));


/*if(mysqli_num_rows($result) > 0) {
	$row = mysqli_fetch_assoc($result);
	echo json_encode(array("Name" => $row["name"], "Email" => $row["email"], "Mobile" => $row["mobile"]));
}*/

?>

<!--  String url = "http://192.168.43.30/volley-standard-request.php"; -->