package ai.spring.demo.ai.playground.services;

import ai.spring.demo.ai.playground.data.*;
import ai.spring.demo.ai.playground.services.BookingTools.BookingDetails;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class FlightBookingService {

	private final BookingData db;

	public FlightBookingService() {
		db = new BookingData();

		initDemoData();
	}

	private void initDemoData() {
		List<String> names = List.of("云小宝", "李千问", "张百炼", "王通义", "刘魔搭");
		List<String> airportCodes = List.of("北京", "上海", "广州", "深圳", "杭州", "南京", "青岛", "成都", "武汉", "西安", "重庆", "大连",
				"天津");
		Random random = new Random();

		var customers = new ArrayList<Customer>();
		var bookings = new ArrayList<Booking>();

		for (int i = 0; i < 5; i++) {
			String name = names.get(i);
			String from = airportCodes.get(random.nextInt(airportCodes.size()));
			String to = airportCodes.get(random.nextInt(airportCodes.size()));
			BookingClass bookingClass = BookingClass.values()[random.nextInt(BookingClass.values().length)];
			Customer customer = new Customer();
			customer.setName(name);

			LocalDate date = LocalDate.now().plusDays(2 * (i + 1));

			Booking booking = new Booking("10" + (i + 1), date, customer, BookingStatus.CONFIRMED, from, to,
					bookingClass);
			customer.getBookings().add(booking);

			customers.add(customer);
			bookings.add(booking);
		}
		List<InventoryDetails> inventoryDetails = initInventory();
		db.setInventoryDetails(inventoryDetails);



		// Reset the database on each start
		db.setCustomers(customers);
		db.setBookings(bookings);
	}

	public List<InventoryDetails>  initInventory(){
		String  jsonData = "[\n" +
				"    {\n" +
				"        \"id\": \"1000256\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0220\",\n" +
				"        \"position_id\": \"\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2995249\",\n" +
				"        \"available_qty\": \"2995209\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"\",\n" +
				"        \"create_time\": \"20/12/2024 20:09:38\",\n" +
				"        \"update_time\": \"24/12/2024 00:05:36\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"2995250\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"QTRKTK-20241220004\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000433\",\n" +
				"        \"material_no\": \"1506070267\",\n" +
				"        \"material_name\": \"挡圈;CKD\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4120\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"200\",\n" +
				"        \"available_qty\": \"200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221094\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:13\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:00:58\",\n" +
				"        \"update_time\": \"21/12/2024 11:00:58\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000434\",\n" +
				"        \"material_no\": \"1506070228\",\n" +
				"        \"material_name\": \"旋翼;Lavorato\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4118\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1030\",\n" +
				"        \"available_qty\": \"1030\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221093\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:25:31\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:02\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:02\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000435\",\n" +
				"        \"material_no\": \"1506100212\",\n" +
				"        \"material_name\": \"外转子\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4116\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1260\",\n" +
				"        \"available_qty\": \"1260\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221085\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151558\",\n" +
				"        \"supplier_name\": \"常州格瑞特粉末冶金有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:25:41\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:07\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:07\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000437\",\n" +
				"        \"material_no\": \"1506070258\",\n" +
				"        \"material_name\": \"联轴器;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4115\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"3040\",\n" +
				"        \"available_qty\": \"3040\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221083\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151558\",\n" +
				"        \"supplier_name\": \"常州格瑞特粉末冶金有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:26:01\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:12\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:12\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000439\",\n" +
				"        \"material_no\": \"1506070228\",\n" +
				"        \"material_name\": \"旋翼;Lavorato\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4117\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2100\",\n" +
				"        \"available_qty\": \"2100\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221093\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:25:31\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:16\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:16\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000440\",\n" +
				"        \"material_no\": \"1506100214\",\n" +
				"        \"material_name\": \"螺丝;ThreadrollingscrewM6\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0322\",\n" +
				"        \"position_id\": \"4112\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"4792\",\n" +
				"        \"available_qty\": \"4792\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221080\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:26:33\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:19\",\n" +
				"        \"update_time\": \"24/12/2024 00:05:45\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"4793\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000441\",\n" +
				"        \"material_no\": \"1506100223\",\n" +
				"        \"material_name\": \"螺丝;SeftthreadscrewM4x18\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0322\",\n" +
				"        \"position_id\": \"4113\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"22796\",\n" +
				"        \"available_qty\": \"22796\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221081\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:26:25\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:22\",\n" +
				"        \"update_time\": \"24/12/2024 00:05:49\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"22797\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000443\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4109\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:27\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:27\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000444\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4110\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"480\",\n" +
				"        \"available_qty\": \"480\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:28\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:28\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000445\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4108\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:31\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:31\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000446\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4107\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:32\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:32\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000447\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4106\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:34\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:34\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000448\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4105\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:37\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:37\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000449\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4103\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:38\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:38\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000450\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4104\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:50\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:50\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000451\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4100\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:51\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:51\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000452\",\n" +
				"        \"material_no\": \"1506100262\",\n" +
				"        \"material_name\": \"连接器;Connectorassembly\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4098\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"864\",\n" +
				"        \"available_qty\": \"864\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221042\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151543\",\n" +
				"        \"supplier_name\": \"昆山宏致电子有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:16\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:56\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:56\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000453\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4101\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:01:58\",\n" +
				"        \"update_time\": \"21/12/2024 11:01:58\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000455\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4102\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:02:04\",\n" +
				"        \"update_time\": \"21/12/2024 11:02:04\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000457\",\n" +
				"        \"material_no\": \"1506100215\",\n" +
				"        \"material_name\": \"泵壳;Machinede-motorhousing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4099\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"600\",\n" +
				"        \"available_qty\": \"600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221064\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:02:09\",\n" +
				"        \"update_time\": \"21/12/2024 11:02:09\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000458\",\n" +
				"        \"material_no\": \"1506100262\",\n" +
				"        \"material_name\": \"连接器;Connectorassembly\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4096\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1296\",\n" +
				"        \"available_qty\": \"1296\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221042\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151543\",\n" +
				"        \"supplier_name\": \"昆山宏致电子有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:16\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:02:11\",\n" +
				"        \"update_time\": \"21/12/2024 11:02:11\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000459\",\n" +
				"        \"material_no\": \"1506100262\",\n" +
				"        \"material_name\": \"连接器;Connectorassembly\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4097\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1296\",\n" +
				"        \"available_qty\": \"1296\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221042\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151543\",\n" +
				"        \"supplier_name\": \"昆山宏致电子有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:16\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:02:15\",\n" +
				"        \"update_time\": \"21/12/2024 11:02:15\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000460\",\n" +
				"        \"material_no\": \"1506100284\",\n" +
				"        \"material_name\": \"连接器;连接器组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0205\",\n" +
				"        \"position_id\": \"4093\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1600\",\n" +
				"        \"available_qty\": \"1600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221017\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"150270\",\n" +
				"        \"supplier_name\": \"安徽天思朴超精密模具有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:32:44\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"1\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:02:16\",\n" +
				"        \"update_time\": \"21/12/2024 11:02:16\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000465\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0120\",\n" +
				"        \"position_id\": \"4074\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"19999999\",\n" +
				"        \"available_qty\": \"19999999\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:02:45\",\n" +
				"        \"update_time\": \"24/12/2024 00:05:53\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"20000000\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000471\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0122\",\n" +
				"        \"position_id\": \"4076\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"12500000\",\n" +
				"        \"available_qty\": \"12500000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:00\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:00\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000477\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0113\",\n" +
				"        \"position_id\": \"4068\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:25\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:25\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000480\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0108\",\n" +
				"        \"position_id\": \"4065\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:32\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:32\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000481\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0121\",\n" +
				"        \"position_id\": \"4075\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:34\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:34\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000482\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0119\",\n" +
				"        \"position_id\": \"4073\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:37\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:37\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000484\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0116\",\n" +
				"        \"position_id\": \"4071\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:42\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:42\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000485\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0115\",\n" +
				"        \"position_id\": \"4070\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:45\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:45\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000487\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0117\",\n" +
				"        \"position_id\": \"4072\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:49\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:49\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000488\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0114\",\n" +
				"        \"position_id\": \"4069\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:50\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:50\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000489\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0109\",\n" +
				"        \"position_id\": \"4066\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:54\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:54\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000490\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0112\",\n" +
				"        \"position_id\": \"4067\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:55\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:55\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000491\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0106\",\n" +
				"        \"position_id\": \"4063\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:04:58\",\n" +
				"        \"update_time\": \"21/12/2024 11:04:58\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000492\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0107\",\n" +
				"        \"position_id\": \"4064\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:05:00\",\n" +
				"        \"update_time\": \"21/12/2024 11:05:00\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000493\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0104\",\n" +
				"        \"position_id\": \"4062\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221023\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:05:01\",\n" +
				"        \"update_time\": \"21/12/2024 11:05:01\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000498\",\n" +
				"        \"material_no\": \"1506070186\",\n" +
				"        \"material_name\": \"挡圈;Giunto\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0404\",\n" +
				"        \"position_id\": \"4028\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"200\",\n" +
				"        \"available_qty\": \"200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221043\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:10\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:05:20\",\n" +
				"        \"update_time\": \"21/12/2024 11:05:20\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000501\",\n" +
				"        \"material_no\": \"1506070254\",\n" +
				"        \"material_name\": \"附属品;Guarnizione\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0101\",\n" +
				"        \"position_id\": \"4054\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"3200\",\n" +
				"        \"available_qty\": \"3200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221004\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"105061\",\n" +
				"        \"supplier_name\": \"上海兴盛密封垫有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:31\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:05:27\",\n" +
				"        \"update_time\": \"21/12/2024 11:05:27\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000504\",\n" +
				"        \"material_no\": \"1506100239\",\n" +
				"        \"material_name\": \"胶水;Gluesensingmagnet\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0414\",\n" +
				"        \"position_id\": \"4042\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"107790\",\n" +
				"        \"available_qty\": \"107790\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221038\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151542\",\n" +
				"        \"supplier_name\": \"科电贸易（上海）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:51\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:05:35\",\n" +
				"        \"update_time\": \"22/12/2024 23:42:33\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000511\",\n" +
				"        \"material_no\": \"1506100241\",\n" +
				"        \"material_name\": \"锡;SolderingTin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0419\",\n" +
				"        \"position_id\": \"4046\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1620000\",\n" +
				"        \"available_qty\": \"1620000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221030\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"23/4/3025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151538\",\n" +
				"        \"supplier_name\": \"贺利氏招远（常熟）电子材料有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:31:02\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:05:58\",\n" +
				"        \"update_time\": \"21/12/2024 11:05:58\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000516\",\n" +
				"        \"material_no\": \"1506100238\",\n" +
				"        \"material_name\": \"胶水;Gluerotormagnet\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0416\",\n" +
				"        \"position_id\": \"4044\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1540000\",\n" +
				"        \"available_qty\": \"1540000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221037\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151542\",\n" +
				"        \"supplier_name\": \"科电贸易（上海）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:58\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:06:19\",\n" +
				"        \"update_time\": \"21/12/2024 11:06:19\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000519\",\n" +
				"        \"material_no\": \"1506100221\",\n" +
				"        \"material_name\": \"永磁发电机\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0415\",\n" +
				"        \"position_id\": \"4043\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"77000\",\n" +
				"        \"available_qty\": \"77000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221022\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151411\",\n" +
				"        \"supplier_name\": \"福建省金龙稀土股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:06:26\",\n" +
				"        \"update_time\": \"21/12/2024 11:06:26\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000530\",\n" +
				"        \"material_no\": \"1506070316\",\n" +
				"        \"material_name\": \"弹簧\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0320\",\n" +
				"        \"position_id\": \"4020\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"3200\",\n" +
				"        \"available_qty\": \"3200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221050\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:29:52\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:06:50\",\n" +
				"        \"update_time\": \"21/12/2024 11:06:50\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000531\",\n" +
				"        \"material_no\": \"1506070229\",\n" +
				"        \"material_name\": \"圆盘\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0324\",\n" +
				"        \"position_id\": \"4024\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"200\",\n" +
				"        \"available_qty\": \"200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221047\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:01\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:06:52\",\n" +
				"        \"update_time\": \"21/12/2024 11:06:52\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000532\",\n" +
				"        \"material_no\": \"1506100236\",\n" +
				"        \"material_name\": \"喷油器体;Plasticlowerinsulator\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0409\",\n" +
				"        \"position_id\": \"4036\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1344\",\n" +
				"        \"available_qty\": \"1344\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221041\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151543\",\n" +
				"        \"supplier_name\": \"昆山宏致电子有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:27\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:06:55\",\n" +
				"        \"update_time\": \"21/12/2024 11:06:55\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000533\",\n" +
				"        \"material_no\": \"1506100236\",\n" +
				"        \"material_name\": \"喷油器体;Plasticlowerinsulator\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0407\",\n" +
				"        \"position_id\": \"4034\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1344\",\n" +
				"        \"available_qty\": \"1344\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221041\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151543\",\n" +
				"        \"supplier_name\": \"昆山宏致电子有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:27\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:06:56\",\n" +
				"        \"update_time\": \"21/12/2024 11:06:56\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000545\",\n" +
				"        \"material_no\": \"1506100203\",\n" +
				"        \"material_name\": \"联接盘;PCBConnector+Insertcomoulded\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0408\",\n" +
				"        \"position_id\": \"3973\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1000\",\n" +
				"        \"available_qty\": \"1000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221102\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/11/2225 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:24\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:28\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:28\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000550\",\n" +
				"        \"material_no\": \"1506100210\",\n" +
				"        \"material_name\": \"泵盖;Machinedpumpcover\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0314\",\n" +
				"        \"position_id\": \"4004\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2880\",\n" +
				"        \"available_qty\": \"2880\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221063\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:51\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:36\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:36\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000551\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0313\",\n" +
				"        \"position_id\": \"4003\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"480\",\n" +
				"        \"available_qty\": \"480\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:21\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:40\",\n" +
				"        \"update_time\": \"21/12/2024 14:32:39\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000552\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0312\",\n" +
				"        \"position_id\": \"4002\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1200\",\n" +
				"        \"available_qty\": \"1200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:21\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:41\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:41\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000553\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0310\",\n" +
				"        \"position_id\": \"4000\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1200\",\n" +
				"        \"available_qty\": \"1200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:21\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:41\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:41\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000554\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0308\",\n" +
				"        \"position_id\": \"3998\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1200\",\n" +
				"        \"available_qty\": \"1200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:21\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:44\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:44\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000555\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0309\",\n" +
				"        \"position_id\": \"3999\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1200\",\n" +
				"        \"available_qty\": \"1200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:21\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:45\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:45\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000557\",\n" +
				"        \"material_no\": \"1506100233\",\n" +
				"        \"material_name\": \"配合销;Phaseend\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0321\",\n" +
				"        \"position_id\": \"3993\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1600\",\n" +
				"        \"available_qty\": \"1600\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221070\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151549\",\n" +
				"        \"supplier_name\": \"苏州铭青机电有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:27:51\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:49\",\n" +
				"        \"update_time\": \"21/12/2024 14:35:45\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000558\",\n" +
				"        \"material_no\": \"1506070256\",\n" +
				"        \"material_name\": \"滑台;PALETTA\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0307\",\n" +
				"        \"position_id\": \"3997\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1400\",\n" +
				"        \"available_qty\": \"1400\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221066\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151546\",\n" +
				"        \"supplier_name\": \"深圳市凯中精密技术股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:28:14\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:50\",\n" +
				"        \"update_time\": \"21/12/2024 14:09:26\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000560\",\n" +
				"        \"material_no\": \"1506100222\",\n" +
				"        \"material_name\": \"转子叠片组;Rotorsheetpack\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0305\",\n" +
				"        \"position_id\": \"3992\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"7700\",\n" +
				"        \"available_qty\": \"7700\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221079\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151554\",\n" +
				"        \"supplier_name\": \"浙江宝捷机电有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:27:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:53\",\n" +
				"        \"update_time\": \"21/12/2024 11:07:53\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000562\",\n" +
				"        \"material_no\": \"1506070246\",\n" +
				"        \"material_name\": \"螺丝;M5x25\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RD0304\",\n" +
				"        \"position_id\": \"3991\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"300\",\n" +
				"        \"available_qty\": \"300\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221072\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151551\",\n" +
				"        \"supplier_name\": \"烟台安国特紧固件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:27:24\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:07:57\",\n" +
				"        \"update_time\": \"21/12/2024 14:08:36\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000565\",\n" +
				"        \"material_no\": \"1506100217\",\n" +
				"        \"material_name\": \"定子叠片组;Statorsheetpack\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0420\",\n" +
				"        \"position_id\": \"3984\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2592\",\n" +
				"        \"available_qty\": \"2592\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221078\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151554\",\n" +
				"        \"supplier_name\": \"浙江宝捷机电有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:26:46\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:02\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:02\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000569\",\n" +
				"        \"material_no\": \"1506100217\",\n" +
				"        \"material_name\": \"定子叠片组;Statorsheetpack\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0421\",\n" +
				"        \"position_id\": \"3985\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2592\",\n" +
				"        \"available_qty\": \"2592\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221078\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151554\",\n" +
				"        \"supplier_name\": \"浙江宝捷机电有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:26:46\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:09\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:09\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000571\",\n" +
				"        \"material_no\": \"850610024001\",\n" +
				"        \"material_name\": \"斜齿轮;Internal\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0419\",\n" +
				"        \"position_id\": \"3982\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221089\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151558\",\n" +
				"        \"supplier_name\": \"常州格瑞特粉末冶金有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:25:36\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:13\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:13\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000572\",\n" +
				"        \"material_no\": \"1506100202\",\n" +
				"        \"material_name\": \"螺丝;M5x18\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0416\",\n" +
				"        \"position_id\": \"3980\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2500\",\n" +
				"        \"available_qty\": \"2500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221075\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151552\",\n" +
				"        \"supplier_name\": \"毅结特紧固件系统（太仓）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:57\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:13\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:13\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000573\",\n" +
				"        \"material_no\": \"1506100192\",\n" +
				"        \"material_name\": \"O形圈;phaseconnection\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0412\",\n" +
				"        \"position_id\": \"3976\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221100\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:34\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:14\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:14\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000578\",\n" +
				"        \"material_no\": \"1506100237\",\n" +
				"        \"material_name\": \"铜丝;Copperwire\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0413\",\n" +
				"        \"position_id\": \"3977\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"303120\",\n" +
				"        \"available_qty\": \"303120\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221090\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/11/2225 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151559\",\n" +
				"        \"supplier_name\": \"大通（福建）新材料股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:21\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:21\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000579\",\n" +
				"        \"material_no\": \"1506100205\",\n" +
				"        \"material_name\": \"O形圈;PCflange/Connectoro-ring\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0414\",\n" +
				"        \"position_id\": \"3978\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1500\",\n" +
				"        \"available_qty\": \"1500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221103\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:40\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:22\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:22\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000580\",\n" +
				"        \"material_no\": \"850610023901\",\n" +
				"        \"material_name\": \"斜齿轮;External\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0409\",\n" +
				"        \"position_id\": \"3974\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221088\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151558\",\n" +
				"        \"supplier_name\": \"常州格瑞特粉末冶金有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:25\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:22\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:22\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000581\",\n" +
				"        \"material_no\": \"1506100207\",\n" +
				"        \"material_name\": \"螺丝;M4x25\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0323\",\n" +
				"        \"position_id\": \"3967\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2000\",\n" +
				"        \"available_qty\": \"2000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221105\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:23:47\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:26\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:26\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000582\",\n" +
				"        \"material_no\": \"1506070192\",\n" +
				"        \"material_name\": \"平键;Spinacilindricad'acciaio\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0405\",\n" +
				"        \"position_id\": \"3970\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221092\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:07\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:26\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:26\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000583\",\n" +
				"        \"material_no\": \"1506100195\",\n" +
				"        \"material_name\": \"定距套筒;Insulationbushing\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0407\",\n" +
				"        \"position_id\": \"3972\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221101\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:20\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:27\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:27\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000584\",\n" +
				"        \"material_no\": \"8506100227\",\n" +
				"        \"material_name\": \"配合销;E-MotorPhaseend1\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0322\",\n" +
				"        \"position_id\": \"3966\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221106\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:23:12\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:29\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:29\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000586\",\n" +
				"        \"material_no\": \"8506100229\",\n" +
				"        \"material_name\": \"配合销;E-Motorphaseend3\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0320\",\n" +
				"        \"position_id\": \"3964\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221108\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:22:33\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:33\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:33\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000587\",\n" +
				"        \"material_no\": \"8506100228\",\n" +
				"        \"material_name\": \"配合销;E-Motorphaseend2\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0321\",\n" +
				"        \"position_id\": \"3965\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221107\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:22:52\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:34\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:34\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000588\",\n" +
				"        \"material_no\": \"1506100294\",\n" +
				"        \"material_name\": \"子组件;转子组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0319\",\n" +
				"        \"position_id\": \"3963\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1680\",\n" +
				"        \"available_qty\": \"1680\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221109\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:20:21\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:34\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:34\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000590\",\n" +
				"        \"material_no\": \"1506100295\",\n" +
				"        \"material_name\": \"定子绕线;定子组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0317\",\n" +
				"        \"position_id\": \"3962\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"32\",\n" +
				"        \"available_qty\": \"32\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221110\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:16:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:38\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:38\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000591\",\n" +
				"        \"material_no\": \"1506100295\",\n" +
				"        \"material_name\": \"定子绕线;定子组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0316\",\n" +
				"        \"position_id\": \"3961\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"768\",\n" +
				"        \"available_qty\": \"768\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221110\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:16:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:38\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:38\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000592\",\n" +
				"        \"material_no\": \"1506100295\",\n" +
				"        \"material_name\": \"定子绕线;定子组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0315\",\n" +
				"        \"position_id\": \"3960\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"768\",\n" +
				"        \"available_qty\": \"768\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221110\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:16:59\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:41\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:41\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000593\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0309\",\n" +
				"        \"position_id\": \"3944\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:42\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:42\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000595\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0313\",\n" +
				"        \"position_id\": \"3946\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:45\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:45\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000596\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0307\",\n" +
				"        \"position_id\": \"3942\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:47\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:47\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000597\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0312\",\n" +
				"        \"position_id\": \"3945\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:48\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:48\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000598\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0308\",\n" +
				"        \"position_id\": \"3943\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:48\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:48\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000599\",\n" +
				"        \"material_no\": \"1506100042\",\n" +
				"        \"material_name\": \"密封盖;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0219\",\n" +
				"        \"position_id\": \"3936\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1800\",\n" +
				"        \"available_qty\": \"1800\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221112\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:32\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:50\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:50\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000600\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0305\",\n" +
				"        \"position_id\": \"3940\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:51\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:51\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000603\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0301\",\n" +
				"        \"position_id\": \"3938\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:08:58\",\n" +
				"        \"update_time\": \"21/12/2024 11:08:58\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000604\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0206\",\n" +
				"        \"position_id\": \"3917\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:02\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:02\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000605\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0213\",\n" +
				"        \"position_id\": \"3922\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:03\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:03\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000606\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0207\",\n" +
				"        \"position_id\": \"3918\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:07\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:07\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000607\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0212\",\n" +
				"        \"position_id\": \"3921\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:07\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:07\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000608\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0204\",\n" +
				"        \"position_id\": \"3915\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:10\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:10\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000609\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0205\",\n" +
				"        \"position_id\": \"3916\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:11\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:11\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000610\",\n" +
				"        \"material_no\": \"1506100041\",\n" +
				"        \"material_name\": \"泵壳;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0306\",\n" +
				"        \"position_id\": \"3941\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"320\",\n" +
				"        \"available_qty\": \"320\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221111\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:13:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:12\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:12\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000611\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0209\",\n" +
				"        \"position_id\": \"3920\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:14\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:14\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000613\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0201\",\n" +
				"        \"position_id\": \"3914\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:17\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:17\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000614\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0208\",\n" +
				"        \"position_id\": \"3919\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:21\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:21\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000615\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0122\",\n" +
				"        \"position_id\": \"3912\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:25\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:25\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000616\",\n" +
				"        \"material_no\": \"1506100206\",\n" +
				"        \"material_name\": \"O形圈;Connector/PCBcovero-ring\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0406\",\n" +
				"        \"position_id\": \"3971\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221104\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:24:17\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"10010647\",\n" +
				"        \"create_time\": \"21/12/2024 11:09:54\",\n" +
				"        \"update_time\": \"21/12/2024 11:09:54\",\n" +
				"        \"update_by\": \"10010647\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"21/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000618\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0123\",\n" +
				"        \"position_id\": \"3913\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"20000000\",\n" +
				"        \"available_qty\": \"20000000\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 19:18:53\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"21/12/2024 11:10:30\",\n" +
				"        \"update_time\": \"21/12/2024 11:10:30\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"20/12/2024 00:00:00\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000852\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0212\",\n" +
				"        \"position_id\": \"731\",\n" +
				"        \"area_id\": \"20\",\n" +
				"        \"area_code\": \"1000E01\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"2\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1\",\n" +
				"        \"available_qty\": \"1\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220205\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"22/12/2024 17:10:57\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"0\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"22/12/2024 17:10:58\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000855\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0220\",\n" +
				"        \"position_id\": \"\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1\",\n" +
				"        \"available_qty\": \"1\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"1\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222003\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"22/12/2024 17:31:48\",\n" +
				"        \"update_time\": \"23/12/2024 13:22:17\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000857\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0215\",\n" +
				"        \"position_id\": \"734\",\n" +
				"        \"area_id\": \"20\",\n" +
				"        \"area_code\": \"1000E01\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"2\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"6\",\n" +
				"        \"available_qty\": \"6\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241222003\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"22/12/2024 18:05:38\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"0\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"22/12/2024 18:05:38\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000858\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0220\",\n" +
				"        \"position_id\": \"\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"3\",\n" +
				"        \"available_qty\": \"3\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"1\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222005\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"22/12/2024 18:14:40\",\n" +
				"        \"update_time\": \"23/12/2024 13:22:17\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000859\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0217\",\n" +
				"        \"position_id\": \"736\",\n" +
				"        \"area_id\": \"20\",\n" +
				"        \"area_code\": \"1000E01\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"2\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"8\",\n" +
				"        \"available_qty\": \"8\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241222005\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"22/12/2024 18:17:37\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"0\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"22/12/2024 18:17:38\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000860\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RC0220\",\n" +
				"        \"position_id\": \"\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"5\",\n" +
				"        \"available_qty\": \"5\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"1\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222007\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"22/12/2024 18:47:02\",\n" +
				"        \"update_time\": \"23/12/2024 13:22:18\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000878\",\n" +
				"        \"material_no\": \"1506100239\",\n" +
				"        \"material_name\": \"胶水;Gluesensingmagnet\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0224\",\n" +
				"        \"position_id\": \"742\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"10\",\n" +
				"        \"available_qty\": \"10\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222011\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"21/12/2024 10:30:51\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"23/12/2024 11:22:59\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000880\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0304\",\n" +
				"        \"position_id\": \"745\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"10\",\n" +
				"        \"available_qty\": \"10\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"23/12/2024 13:22:13\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000883\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0304\",\n" +
				"        \"position_id\": \"745\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"3\",\n" +
				"        \"available_qty\": \"3\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222002\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"23/12/2024 13:22:17\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000884\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0304\",\n" +
				"        \"position_id\": \"745\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"5\",\n" +
				"        \"available_qty\": \"5\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222003\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"23/12/2024 13:22:17\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000885\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0304\",\n" +
				"        \"position_id\": \"745\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"5\",\n" +
				"        \"available_qty\": \"5\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222005\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"23/12/2024 13:22:18\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000886\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销; Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0304\",\n" +
				"        \"position_id\": \"745\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"5\",\n" +
				"        \"available_qty\": \"5\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"O\",\n" +
				"        \"stock_in_lot\": \"V241222007\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"20/12/2024 20:09:38\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2995296\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test_func\",\n" +
				"        \"create_time\": \"23/12/2024 13:22:18\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test_func\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000889\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0305\",\n" +
				"        \"position_id\": \"746\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"200\",\n" +
				"        \"available_qty\": \"200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220209\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:09:46\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"200\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:09:46\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000890\",\n" +
				"        \"material_no\": \"1506100228\",\n" +
				"        \"material_name\": \"螺丝;ThreadrollingscrrewM2.5\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0323\",\n" +
				"        \"position_id\": \"1452\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"1300\",\n" +
				"        \"available_qty\": \"1300\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221082\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:09:48\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1300\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:09:48\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000891\",\n" +
				"        \"material_no\": \"1506070227\",\n" +
				"        \"material_name\": \"旋翼;ROTORE;Rotoregrezzo\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"SB0105\",\n" +
				"        \"position_id\": \"59\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"3200\",\n" +
				"        \"available_qty\": \"3200\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221046\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:11:22\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"3200\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:11:22\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000892\",\n" +
				"        \"material_no\": \"1506100242\",\n" +
				"        \"material_name\": \"电路板;montaggioPCBcollaudato\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"SB0105\",\n" +
				"        \"position_id\": \"59\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72\",\n" +
				"        \"available_qty\": \"72\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221071\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"3/4/2075 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151550\",\n" +
				"        \"supplier_name\": \"无锡和晶智能科技有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:11:24\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:11:24\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000893\",\n" +
				"        \"material_no\": \"8506100262\",\n" +
				"        \"material_name\": \"螺丝;ScrewM5x20\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"SB0105\",\n" +
				"        \"position_id\": \"59\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"500\",\n" +
				"        \"available_qty\": \"500\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221003\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"102729\",\n" +
				"        \"supplier_name\": \"米思米（中国）精密机械贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:11:26\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"500\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:11:26\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000894\",\n" +
				"        \"material_no\": \"1506100285\",\n" +
				"        \"material_name\": \"泵盖;塑料PCB盖\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"SB0105\",\n" +
				"        \"position_id\": \"59\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"720\",\n" +
				"        \"available_qty\": \"720\",\n" +
				"        \"prepared_qty\": \"0\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221018\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"150270\",\n" +
				"        \"supplier_name\": \"安徽天思朴超精密模具有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:11:27\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"720\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:11:27\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000895\",\n" +
				"        \"material_no\": \"1506100042\",\n" +
				"        \"material_name\": \"密封盖;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0306\",\n" +
				"        \"position_id\": \"747\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"4\",\n" +
				"        \"available_qty\": \"4\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241219101\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"19/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"MS事业部\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:11:58\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"4\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:11:58\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000898\",\n" +
				"        \"material_no\": \"1506070229\",\n" +
				"        \"material_name\": \"圆盘\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0306\",\n" +
				"        \"position_id\": \"747\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"9\",\n" +
				"        \"available_qty\": \"9\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221252\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:12:06\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"9\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:12:06\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000899\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0307\",\n" +
				"        \"position_id\": \"748\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"199800\",\n" +
				"        \"available_qty\": \"199800\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220209\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:15:35\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"199800\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:15:35\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000900\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0307\",\n" +
				"        \"position_id\": \"748\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"200000\",\n" +
				"        \"available_qty\": \"200000\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220248\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:15:38\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"200000\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:15:38\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000904\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0308\",\n" +
				"        \"position_id\": \"749\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"200000\",\n" +
				"        \"available_qty\": \"200000\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220208\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:16:57\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"200000\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:16:57\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000911\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0309\",\n" +
				"        \"position_id\": \"750\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"200000\",\n" +
				"        \"available_qty\": \"200000\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220206\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 15:18:10\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"200000\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 15:18:10\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000919\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:21\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:21\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000921\",\n" +
				"        \"material_no\": \"1506100223\",\n" +
				"        \"material_name\": \"螺丝;SeftthreadscrewM4x18\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0324\",\n" +
				"        \"position_id\": \"1453\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1\",\n" +
				"        \"available_qty\": \"1\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221081\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:28\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:28\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000922\",\n" +
				"        \"material_no\": \"1506100214\",\n" +
				"        \"material_name\": \"螺丝;ThreadrollingscrewM6\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0324\",\n" +
				"        \"position_id\": \"1453\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"5\",\n" +
				"        \"available_qty\": \"5\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221080\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:29\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"5\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:29\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000923\",\n" +
				"        \"material_no\": \"1506070269\",\n" +
				"        \"material_name\": \"圆盘;CKD\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1200\",\n" +
				"        \"available_qty\": \"1200\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221096\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:30\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1200\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:30\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000924\",\n" +
				"        \"material_no\": \"1506100216\",\n" +
				"        \"material_name\": \"配合销;Pin\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"4\",\n" +
				"        \"available_qty\": \"4\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221069\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151549\",\n" +
				"        \"supplier_name\": \"苏州铭青机电有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:32\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"4\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:32\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000927\",\n" +
				"        \"material_no\": \"1506100220\",\n" +
				"        \"material_name\": \"吸轴;Shaft\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"2500\",\n" +
				"        \"available_qty\": \"2500\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221027\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151535\",\n" +
				"        \"supplier_name\": \"大连德迈仕精密科技股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:36\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2500\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:36\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000928\",\n" +
				"        \"material_no\": \"1506100286\",\n" +
				"        \"material_name\": \"摆线泵;烧结外齿轮\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"4304\",\n" +
				"        \"available_qty\": \"4304\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221019\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"150306\",\n" +
				"        \"supplier_name\": \"吉凯恩粉末冶金（仪征）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 19:42:37\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"4304\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 19:42:37\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000932\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:27:50\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:27:50\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000933\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:29:56\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:29:56\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000934\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:31:00\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:31:00\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000935\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:31:08\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:31:08\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000936\",\n" +
				"        \"material_no\": \"1506100258\",\n" +
				"        \"material_name\": \"电路板; montaggio PCB collaudato\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0314\",\n" +
				"        \"position_id\": \"\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"2888\",\n" +
				"        \"available_qty\": \"2888\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:32:44\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"2888\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"\",\n" +
				"        \"create_time\": \"23/12/2024 20:32:44\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"QTRKTK-20241223001\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000937\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:40:42\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:40:42\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000938\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:40:43\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:40:43\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000939\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:40:44\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:40:44\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000940\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:40:45\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:40:45\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000941\",\n" +
				"        \"material_no\": \"\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"72500004\",\n" +
				"        \"available_qty\": \"72500004\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:40:47\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:40:47\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000942\",\n" +
				"        \"material_no\": \"1506100223\",\n" +
				"        \"material_name\": \"螺丝;SeftthreadscrewM4x18\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0401\",\n" +
				"        \"position_id\": \"1454\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"2\",\n" +
				"        \"available_qty\": \"2\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221081\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 20:56:21\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 20:56:19\",\n" +
				"        \"update_time\": \"23/12/2024 22:34:31\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000943\",\n" +
				"        \"material_no\": \"1506100282\",\n" +
				"        \"material_name\": \"锡;焊接锡\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"290000017\",\n" +
				"        \"available_qty\": \"290000017\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241220172\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"20/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151472\",\n" +
				"        \"supplier_name\": \"确信爱法金属（上海）贸易有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 21:03:28\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"G\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"72500004\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 21:03:28\",\n" +
				"        \"update_time\": \"23/12/2024 22:14:55\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000944\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1206\",\n" +
				"        \"available_qty\": \"1206\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 22:16:20\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1200\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 22:16:06\",\n" +
				"        \"update_time\": \"23/12/2024 23:23:49\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000945\",\n" +
				"        \"material_no\": \"1506100295\",\n" +
				"        \"material_name\": \"定子绕线;定子组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0312\",\n" +
				"        \"position_id\": \"751\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1400\",\n" +
				"        \"available_qty\": \"1400\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221110\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 22:19:00\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1400\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 22:19:00\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000946\",\n" +
				"        \"material_no\": \"1506100295\",\n" +
				"        \"material_name\": \"定子绕线;定子组件\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"4\",\n" +
				"        \"available_qty\": \"4\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221110\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151540\",\n" +
				"        \"supplier_name\": \"锦州韩华电装有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 22:20:27\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 22:20:27\",\n" +
				"        \"update_time\": \"23/12/2024 22:56:20\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000947\",\n" +
				"        \"material_no\": \"1506100214\",\n" +
				"        \"material_name\": \"螺丝;ThreadrollingscrewM6\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"FH0401\",\n" +
				"        \"position_id\": \"1454\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1\",\n" +
				"        \"available_qty\": \"1\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221080\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151557\",\n" +
				"        \"supplier_name\": \"阿诺德紧固件（沈阳）有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 22:56:36\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 22:56:36\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000948\",\n" +
				"        \"material_no\": \"1506070269\",\n" +
				"        \"material_name\": \"圆盘;CKD\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"3\",\n" +
				"        \"available_qty\": \"3\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221096\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151578\",\n" +
				"        \"supplier_name\": \"VHIT S.p.A. - Società Uniperso\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 22:56:59\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 22:56:59\",\n" +
				"        \"update_time\": \"23/12/2024 22:59:14\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000949\",\n" +
				"        \"material_no\": \"1506100227\",\n" +
				"        \"material_name\": \"泵盖;MachinedPCBflange\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0313\",\n" +
				"        \"position_id\": \"752\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1200\",\n" +
				"        \"available_qty\": \"1200\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221065\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151545\",\n" +
				"        \"supplier_name\": \"上海诺信汽车零部件有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 22:57:06\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1200\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 22:57:06\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000951\",\n" +
				"        \"material_no\": \"8506100262\",\n" +
				"        \"material_name\": \"螺丝; Screw M5x20\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0315\",\n" +
				"        \"position_id\": \"754\",\n" +
				"        \"area_id\": \"\",\n" +
				"        \"area_code\": \"\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"\",\n" +
				"        \"inventory_qty\": \"4500\",\n" +
				"        \"available_qty\": \"4500\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"\",\n" +
				"        \"supplier_name\": \"\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 23:47:12\",\n" +
				"        \"warehouse_id\": \"\",\n" +
				"        \"warehouse_code\": \"\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"4500\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 23:47:12\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000952\",\n" +
				"        \"material_no\": \"1506070194\",\n" +
				"        \"material_name\": \"橡胶密封座\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0315\",\n" +
				"        \"position_id\": \"754\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"3200\",\n" +
				"        \"available_qty\": \"3200\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221044\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 23:47:17\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"3200\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 23:47:17\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000953\",\n" +
				"        \"material_no\": \"1506070186\",\n" +
				"        \"material_name\": \"挡圈;Giunto\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0315\",\n" +
				"        \"position_id\": \"754\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"3000\",\n" +
				"        \"available_qty\": \"3000\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221043\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"16/12/2398 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 23:47:18\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"3000\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 23:47:18\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000955\",\n" +
				"        \"material_no\": \"1506070261\",\n" +
				"        \"material_name\": \"保护栓;CUPVNR\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0315\",\n" +
				"        \"position_id\": \"754\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1\",\n" +
				"        \"available_qty\": \"1\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221049\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"23/12/2024 23:48:00\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"23/12/2024 23:48:00\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000956\",\n" +
				"        \"material_no\": \"1506100042\",\n" +
				"        \"material_name\": \"密封盖;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0316\",\n" +
				"        \"position_id\": \"755\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1877\",\n" +
				"        \"available_qty\": \"1877\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241219101\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"19/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"MS事业部\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"24/12/2024 09:27:40\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1877\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"24/12/2024 09:27:40\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000957\",\n" +
				"        \"material_no\": \"1506100236\",\n" +
				"        \"material_name\": \"喷油器体;Plasticlowerinsulator\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0316\",\n" +
				"        \"position_id\": \"755\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"3168\",\n" +
				"        \"available_qty\": \"3168\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221041\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151543\",\n" +
				"        \"supplier_name\": \"昆山宏致电子有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"24/12/2024 09:27:42\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"3168\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"24/12/2024 09:27:42\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000959\",\n" +
				"        \"material_no\": \"1506070261\",\n" +
				"        \"material_name\": \"保护栓;CUPVNR\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0316\",\n" +
				"        \"position_id\": \"755\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1\",\n" +
				"        \"available_qty\": \"1\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221049\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"151544\",\n" +
				"        \"supplier_name\": \"上海凯门机电设备有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"24/12/2024 09:28:05\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"24/12/2024 09:28:05\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"id\": \"1000961\",\n" +
				"        \"material_no\": \"1506100042\",\n" +
				"        \"material_name\": \"密封盖;D299\",\n" +
				"        \"old_material_no\": \"\",\n" +
				"        \"position_no\": \"RE0317\",\n" +
				"        \"position_id\": \"756\",\n" +
				"        \"area_id\": \"137\",\n" +
				"        \"area_code\": \"1001E99\",\n" +
				"        \"seq_no\": \"\",\n" +
				"        \"location_id\": \"1\",\n" +
				"        \"location_code\": \"1000\",\n" +
				"        \"factory_id\": \"117\",\n" +
				"        \"factory_code\": \"VH00\",\n" +
				"        \"factory_name\": \"VHIT Automotive systems (Wuxi)\",\n" +
				"        \"inventory_qty\": \"1368\",\n" +
				"        \"available_qty\": \"1368\",\n" +
				"        \"prepared_qty\": \"\",\n" +
				"        \"stock_spec_flag\": \"0\",\n" +
				"        \"stock_spec_type\": \"\",\n" +
				"        \"stock_in_lot\": \"V241221112\",\n" +
				"        \"production_lot\": \"\",\n" +
				"        \"valid_days\": \"\",\n" +
				"        \"expiry_date\": \"21/12/2025 00:00:00\",\n" +
				"        \"spec_flag\": \"\",\n" +
				"        \"supplier_id\": \"\",\n" +
				"        \"supplier_code\": \"MS00-00\",\n" +
				"        \"supplier_name\": \"无锡威孚高科技集团股份有限公司\",\n" +
				"        \"container_no\": \"\",\n" +
				"        \"container_type\": \"\",\n" +
				"        \"stock_in_date\": \"24/12/2024 09:46:09\",\n" +
				"        \"warehouse_id\": \"27\",\n" +
				"        \"warehouse_code\": \"VH00\",\n" +
				"        \"is_qc\": \"0\",\n" +
				"        \"is_freeze\": \"0\",\n" +
				"        \"is_consign\": \"0\",\n" +
				"        \"reserved_qty\": \"\",\n" +
				"        \"is_reserved\": \"0\",\n" +
				"        \"tenant_id\": \"6\",\n" +
				"        \"dept_id\": \"\",\n" +
				"        \"unit\": \"EA\",\n" +
				"        \"operation_inventory_qty\": \"\",\n" +
				"        \"operation_available_qty\": \"1368\",\n" +
				"        \"operation_prepared_qty\": \"\",\n" +
				"        \"operation_unit\": \"\",\n" +
				"        \"convers_default\": \"\",\n" +
				"        \"create_by\": \"test001\",\n" +
				"        \"create_time\": \"24/12/2024 09:46:09\",\n" +
				"        \"update_time\": \"\",\n" +
				"        \"update_by\": \"test001\",\n" +
				"        \"location_type\": \"\",\n" +
				"        \"special_type\": \"\",\n" +
				"        \"wbs_element\": \"\",\n" +
				"        \"old_mes_container_no\": \"\",\n" +
				"        \"old_qty\": \"\",\n" +
				"        \"hu_no\": \"0\",\n" +
				"        \"product_time\": \"\",\n" +
				"        \"move_type\": \"\",\n" +
				"        \"task_no\": \"\"\n" +
				"    }\n" +
				"]";
		// 配置 ParserConfig 以支持下划线命名
		ParserConfig config = new ParserConfig();
		config.propertyNamingStrategy = com.alibaba.fastjson.PropertyNamingStrategy.SnakeCase;
		TypeReference<List<BookingDetails>> typeReference = new TypeReference<>() {
		};
		return JSON.parseArray(jsonData,InventoryDetails.class,config);
	}

	public List<BookingDetails> getBookings() {
		return db.getBookings().stream().map(this::toBookingDetails).toList();
	}

	private Booking findBooking(String bookingNumber, String name) {
		return db.getBookings()
			.stream()
			.filter(b -> b.getBookingNumber().equalsIgnoreCase(bookingNumber))
			.filter(b -> b.getCustomer().getName().equalsIgnoreCase(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
	}

	public BookingDetails getBookingDetails(String bookingNumber, String name) {
		var booking = findBooking(bookingNumber, name);
		return toBookingDetails(booking);
	}

	public void changeBooking(String bookingNumber, String name, String newDate, String from, String to) {
		var booking = findBooking(bookingNumber, name);
		if (booking.getDate().isBefore(LocalDate.now().plusDays(1))) {
			throw new IllegalArgumentException("Booking cannot be changed within 24 hours of the start date.");
		}
		booking.setDate(LocalDate.parse(newDate));
		booking.setFrom(from);
		booking.setTo(to);
	}

	public void cancelBooking(String bookingNumber, String name) {
		var booking = findBooking(bookingNumber, name);
		if (booking.getDate().isBefore(LocalDate.now().plusDays(2))) {
			throw new IllegalArgumentException("Booking cannot be cancelled within 48 hours of the start date.");
		}
		booking.setBookingStatus(BookingStatus.CANCELLED);
	}


	public void printBookings() {
		for (Booking booking : db.getBookings()) {
			System.out.println("Booking Number: " + booking.getBookingNumber());
			System.out.println("Customer Name: " + booking.getCustomer().getName());
		}
	}

	private BookingDetails toBookingDetails(Booking booking) {
		return new BookingDetails(booking.getBookingNumber(), booking.getCustomer().getName(), booking.getDate(),
				booking.getBookingStatus(), booking.getFrom(), booking.getTo(), booking.getBookingClass().toString());
	}

	public List<InventoryDetails> findMaterialDetails(String s) {
		System.out.println(s);
		return  db.getInventoryDetails().stream().filter(i -> i.getMaterialNo().equals(s)).collect(Collectors.toList());
	}
}
