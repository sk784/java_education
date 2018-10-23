public class MainMarathon {
    public static void main(String[] args) {
        Course c = new Course(200,6,1);
        Team team = new Team("Несокрушимые",
                "Иванов Иван",300,200,1,
                "Петя",200,300,2,
                "Пес Барбос",500,6,5,
                "Кот Матроскин",400,0,3);

        c.doit(team); // Просим команду пройти полосу
        team.info(); // Показываем результаты




        /*Competitor[] competitors = {new Cat("Барсик",200,0,3), new Dog("Бобик",100,25,3)};
        Obstacle[] obstacles = {new Cross(80), new Wall(2), new Water(10)};

        for (Competitor c: competitors) {
            for (Obstacle o: obstacles) {
                o.doit(c);
                if(!c.isOnDistance()) {
                    break;
                }
            }
        }

        for (Competitor c: competitors) {
            c.info();
        }

        */
    }
}

