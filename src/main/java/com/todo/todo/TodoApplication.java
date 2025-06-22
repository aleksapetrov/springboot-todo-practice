package com.todo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {


		SpringApplication.run(TodoApplication.class, args);

		// monolitične veb aplikacije
		// baza podataka + html stranice(thymeleaf)

		// aplikacije kao response daje html kodove


		// rest api
		// baza podataka i za odgovor daje podatke u obliku json


		// backend: rest api instagram (salje podatke u obliku json)


		// klijent: veb aplikacija, mobilna apl ios, android, desktop aplikacija... i svi oni salju zahteve ka rest api



		// /proizvodi - POST

		// /narudzbine

		// /proizvodi/3 - GET

		// /proizvodi/7 - DELETE

		// /proizvodi - POST
		// /proizvodi - GET

		// GET - dobavljanje
		// POST - dodavanje informacije
		// PUT - izmena podataka
		// DELETE - brisanie


		// podaci se salju preko json

		//
		/*
		{
			"ime": "Telefon",
			"cena": 20000,
			"kolicina": 20

		}
		*/

		// DOMACI
		// pročitaj o REST API arhitekturi

		// DOMACI2
		// pročitaj šta je servisni sloj(service) u spring boot


		// zadatak napravi novi entitet User koji ima atribute id, firstName, lastName, email, username


		// DOMACI

		// napravi novi projekat preko Spring initializr, izmisli neke entitete i napravi  za njih repozitorijume


		/*

			[
				{"title":"asd", "description":"adsda"...},{"title":"dsad"...}

			]


		 */

		/*
			POST

			{
			"title":"sadasd",
			"description":"adsada"
			}


			{
				"id":34
				"title":"asdsa",

				....

			}


		 */


		// serijalizacija: objekat -> json

		// deserijalizacija: json -> objekat


		// /tasks - GET
		// /tasks - POST

		// /tasks/<id> - DELETE

		// /tasks/<id> - PUT


		// /tasks/<id>    -  GET

		// PATCH

		// DOMACI
		// napravi novu aplikacija sa nekim novim entitetom, repozitorijum, i kontroler gde se nalaze sve rute za crud operacije

		// repozitorijum <- servis <- kontroler


		// Skini POSTMAN program


		// DOMACI2
		// pogledaj ManyToMany anotaciju u spring bootu

		// MANY TO MANY

		// knjiga

		// zanrova


		// many to many izmedju knjige i zanra

		// knjiga -id, naziv, autor
		// zanr - id, naziv

		// knjiga_zanr (knjiga_id, zanr_id)
		// 1, 2
		// 1, 3
		// 1, 5
		// 2, 7
		// 10, 7
		// 10, 2



		// many to one

		// user
		// task

		// user ima vise taskova
		// task samo pripada jednom korisnika

		// istovremeno one to many



		// one to one

		// student
		// student_podaci




		// napravi kontroler AuthenticationController
		// i napravi tamo rutu /auth/register - POST
		// koja sluzi za registraciju korisnika


		// DOMACI3
		// pročitaj o JWT autentikaciju



		//DOMACI 4

		// (BONUS) probaj da implementiraš ManyToMany vezu za auto i oprema (čitaj dokumentaciju na netu)


		// DOMACI5
		// skini postman i testiraj tovju aplikaciju


		// /tasks - GET (dobavljanje svih taskova)
		// /tasks - POST (za dodavanje taskova)
		// /tasks/id - GET (dobavlja task sa tim id-em)
		// /tasks/id - PUT (izmena task-a sa tim id-em)
		// /tasks/id - DELETE (obrisati task sa tim id-em)
		// /tasks/id/finish - POST (za menjanje atributa finished)


		// /auth/register


		// DOMACI

		// napravi aplikaciju koja ima sledece entiteti:
		// Product(id, name, price, quantity)
		// Order(id, orderedAt)
		// OrderDetail(id, order, product, quantity, price)


		// repozitorijumi, servisi..


		// /products - GET
		// /products/id - GET

		// /products - POST


		// orders - GET
		// orders/id - GET
		// orders/id/orderdetails - GET (vraca sve order details za jednu narudzbinu)


		// / testiraj rute preko postman-a


		// /tasks?title=zadatak - GET

		// query parametri služe za filtriranje resursa


		// a kad pristupamo resursima onda koristimo path variable

		// path variable i query parameters

		// proizvodi/id

		// proizvodi?minCena=200


		// /proizvodi?minCena=200&maxCena=700


		//DOMACI
		// (named jpa queries)

		// u tvom projektu dopuni rutu products da uzima query parametre minPrice i maxPrice
		// i vraća proizvode koji su u tom intervalu cena


		//DOMACI2
		// testiraj sve te rute koje imaš



		// DOMACI3
		// product, order, orderdetail
		// ponovi ovo sve staro šta smo radili

		// DOMACI4
		// u tvom projektu dopuni rutu orders da uzima query parametre minDate i maxDAte
		// i vraća narudzbine koji su u tom intervalu vremena




		// /auth/register
		// /auth/login

		// users/id/tasks - GET
		// users/id/tasks - POST

		// tasks/id - DELETE
		// tasks/id - PUT
		// tasks/id - GET

		// /users - GET



		// gigatron.com/proizvodi/laptopovi?minCena=20000&maxCena=40000&proizvodjac=ACER

		// gigatron.com/proizvodi/laptopovi


		// facebook.com/profile.php?id=3243243243242

		// TODO domaci
		// testiraj sve rute preko postman

		// TODO domaci
		// napravi rutu /users - GET
		// koja vraža listu svih korisnika

		// TODO domaci
		// napravi rutu /users/id - DELETE
		// koja sluzi za brisanje korisnika sa tim id-em

		// TODO domaci

		// za rute tasks/id - PUT, DELETE
		// stavi proveru da li postoji task sa tim id-em, ako ne postoji vrati status kod 404


		// request parametri - query parametri

		// paginacija

		// DTO klasama, "izvestaji"

		// validacija podataka

		// Query anotacija / HQL


		// users/id/tasks?search=domaci





	// TODO DOMACI
		// na rutu /users stavi da postoji query parametar search
		// i da sluzi za filtriranje korisnika po username(sadrzi se i ignore case)


		// /users?search=john

		// xjohnx, john123...

		// TODO DOMACI

		// procitaj na netu malo vise o Page klasi, Pageable klasi itd.


		// TODO DOMACI

		// napravi novi entitet Category koji ima sledece atribute id, name, user

		// napravi CategoryRepository

		// CategoryService i CategoryServiceImpl (add, findById, findAll, deleteById...)


		// TODO DOMACI

		// procitaj na netu sta je many-to-many veza u bazi podataka
		// i pogledaj kako se to implementira u hibernate
		// BONUS: probaj da povezes Task i Category da imaju many to many vezu


		/*
		knjige

		zanr

		knjiga_zanr
		1, 5
		1, 7
		2, 5



		 */


		// TODO domaci
		// napraviti rutu users/id/categories - POST


		// TODO domaci 2
		// napraviti rute
		// categories/id - GET
		// categories/id - DELETE
		// categories/id - PUT


		// napravi nam rutu tasks/id/categories - GET
		// ova ruta vraća listu kategoriju
		// i ako task sa tim id-em ne postoji vraca 404

		// TODO domaci

		// napravi rutu categories/id/tasks - GET

		// User/Documents/Pictures/Rodjendan
		//D:\Users\Aleksa\Desktop\Precice\Engines



		// TODO domaci2

		// treba nam ruta da se kategorija poveze sa odredjenim taskom

		// /tasks/id/categories/id - POST

		// tasks/id/categories/id - DELETE







		// ovo je primer kako bi moglo da izgleda(ne treba nam za ovaj projekat)


		// TaskCategory

		// task id, category id, order, priortet

		// taskcategory - POST
		// taskcategory/id - DELETE



		 // TODO DOMACI


		// prvi nacin

		// message
		// text, fromUser, toUser, localDateTime



		// DRUGI NAČIN

		// chat
		// id, name, isGroup

		// message
		// id, text, user, chat, localDateTime

		// chatmember

		// id, user, chat, grouprole(enum)


		// DOMACI



		// users/id/chats - GET, daje sve cetove u kojem se korisnik sa tim id-em nalazi

		// (ovo ce ti dati listu cetova u kojima taj korisnik pripada, i u chatmember tabeli se cuva koji korisnik se nalazi u kojem cetu)

		// DOMACI 2
		// chats/id/chat-member - GET
		// chats/id/messages - GET
		// chats/id/messages - POST

		// {"text": "zdravo ljudi!"}



	// DOMACI 3
		// pročitaj o PATCH









	}

}
