package com.mentorat_virtuel.projet_mentorat_virtuel;

import java.util.Date;

public record ErrorMessage(int status, String msg, String error, Date timestamp)  {
}
