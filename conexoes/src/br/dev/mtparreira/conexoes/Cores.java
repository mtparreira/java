package br.dev.mtparreira.conexoes;

public enum Cores {
    
    BLACK				("\033[0;30m"), BLACK_BRIGHT				("\033[0;90m"),
    BLUE				("\033[0;34m"), BLUE_BRIGHT					("\033[0;94m"),
    CYAN				("\033[0;36m"), CYAN_BRIGHT					("\033[0;96m"),
    GREEN				("\033[0;32m"), GREEN_BRIGHT				("\033[0;92m"),
    MAGENTA				("\033[0;35m"), MAGENTA_BRIGHT				("\033[0;95m"),
    RED					("\033[0;31m"), RED_BRIGHT					("\033[0;91m"),
    WHITE				("\033[0;37m"), WHITE_BRIGHT				("\033[0;97m"),
    YELLOW				("\033[0;33m"), YELLOW_BRIGHT				("\033[0;93m"),
    
    BLACK_BOLD			("\033[1;30m"), BLACK_BOLD_BRIGHT			("\033[1;90m"),
    BLUE_BOLD			("\033[1;34m"), BLUE_BOLD_BRIGHT			("\033[1;94m"),
    CYAN_BOLD			("\033[1;36m"), CYAN_BOLD_BRIGHT			("\033[1;96m"),
    GREEN_BOLD			("\033[1;32m"), GREEN_BOLD_BRIGHT			("\033[1;92m"),
    MAGENTA_BOLD		("\033[1;35m"), MAGENTA_BOLD_BRIGHT			("\033[1;95m"),
    RED_BOLD			("\033[1;31m"), RED_BOLD_BRIGHT				("\033[1;91m"),
    WHITE_BOLD			("\033[1;37m"), WHITE_BOLD_BRIGHT			("\033[1;97m"),
    YELLOW_BOLD			("\033[1;33m"), YELLOW_BOLD_BRIGHT			("\033[1;93m"),

    BLACK_BACKGROUND	("\033[40m"), 	BLACK_BACKGROUND_BRIGHT		("\033[0;100m"),
    BLUE_BACKGROUND		("\033[44m"), 	BLUE_BACKGROUND_BRIGHT		("\033[0;104m"),
    CYAN_BACKGROUND		("\033[46m"), 	CYAN_BACKGROUND_BRIGHT		("\033[0;106m"),
    GREEN_BACKGROUND	("\033[42m"), 	GREEN_BACKGROUND_BRIGHT		("\033[0;102m"),
    MAGENTA_BACKGROUND	("\033[45m"), 	MAGENTA_BACKGROUND_BRIGHT	("\033[0;105m"),
    RED_BACKGROUND		("\033[41m"), 	RED_BACKGROUND_BRIGHT		("\033[0;101m"),
    WHITE_BACKGROUND	("\033[47m"), 	WHITE_BACKGROUND_BRIGHT		("\033[0;107m"),
    YELLOW_BACKGROUND	("\033[43m"), 	YELLOW_BACKGROUND_BRIGHT	("\033[0;103m"),
        
    BLACK_UNDERLINED	("\033[4;30m"),
    BLUE_UNDERLINED		("\033[4;34m"),
    CYAN_UNDERLINED		("\033[4;36m"),
    GREEN_UNDERLINED	("\033[4;32m"),
    MAGENTA_UNDERLINED	("\033[4;35m"),
    RED_UNDERLINED		("\033[4;31m"),
    WHITE_UNDERLINED	("\033[4;37m"),
    YELLOW_UNDERLINED	("\033[4;33m"),
	
	RESET				("\033[0m");
	
	private String codigo;
	
	private Cores(String codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return codigo;
	}	

}
