package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//Busca por ID
		
		System.out.println("=== TESTE 1: Seller findByID ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		//Busca por departamento
		
		System.out.println("\n=== TESTE 2: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		//Buscando todos os ID
		
		System.out.println("\n=== TESTE 3: Seller findByAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		//Aplicando inserção no BD
		
		System.out.println("\n=== TESTE 4: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Iserted! New id = " + newSeller.getId());
		
		//Aplicando atualização de dados
		
		System.out.println("\n=== TESTE 5: Seller update ===");
		seller = sellerDao.findById(1);
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		//Excluindo dados
		
		System.out.println("\n=== TESTE 6: Seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.print("Delete completed");
		
		sc.close();
	}
}
