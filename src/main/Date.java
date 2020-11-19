package main;

public class Date {
	private int jour, mois, annee;

	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/*
	 * public int getJour() { return jour; }
	 * 
	 * public int getMois() { return mois; }
	 * 
	 * public int getAnnee() { return annee; }
	 */

	public String getDate() {
		return jour + "/" + mois + "/" + annee;
	}

	public void validiteDate() throws Exception {
		if (jour < 1 || jour > 31)
			throw new ArithmeticException("Jour doit etre entre 1 et 31.");
		if (mois < 1 || mois > 12)
			throw new ArithmeticException("Mois doit etre entre 1 et 12.");
		if (annee < 1000 || annee > 3000)
			throw new ArithmeticException("Annee doit etre entre 1000 et 3000.");
		if (!anneeBisextile() && mois == 2 && jour > 28)
			throw new ArithmeticException("Fevrier n'a que 28 jours.");
		if (anneeBisextile() && mois == 2 && jour > 29)
			throw new ArithmeticException("Annee Bissextile Fevrier n'a que 29 jours.");
		if (((mois == 4) || (mois == 6) || (mois == 9) || (mois == 11)) && jour > 30)
			throw new ArithmeticException("ce mois n'a que 30 jours.");

	}

	public Date lendemain() throws Exception {
		validiteDate();
		// Si on est le 28 Février et que l'année n'est pas bisextille, alors le
		// lendemain c'est le premier Mars
		if ((jour == 28) && (mois == 2) && !anneeBisextile())
			return new Date(1, 3, this.annee);
		// Si on est le 29 Février, alors le lendemein c'est le premier Mars
		if ((jour == 29) && (mois == 2))
			return new Date(1, 3, this.annee);
		// Si on est le 30 du mois et que le mois soit Avril, Juin, Septemebre ou
		// Novembre, Alors le lendemain c'est le premier du mois suivant
		if ((jour == 30) && ((mois == 4) || (mois == 6) || (mois == 9) || (mois == 11)))
			return new Date(1, mois + 1, annee);
		// Si on est le 31 du mois
		if (jour == 31) {
			// Si on est en decembre, alors le lendemain est le premier janvier de l'année
			// suivante
			if (mois == 12)
				return new Date(1, 1, annee + 1);
			// Dans les autres cas, le lendemein est le premier du mois suivant
			return new Date(1, mois + 1, annee);
		}
		// Si on est pas en fin de mois, le lendemain, est simplement le jour suivant
		return new Date(jour + 1, mois, annee);
	}

	public boolean anneeBisextile() {
		// Si l'anné n'est pas divisible par 4, alors, elle n'est pas bisextile
		if (annee % 4 != 0)
			return false;
		// Ici on est sur que l'année est divisible par 4
		// Si l'année n'est pas divisible par 100, alors elle est bisextille
		if (annee % 100 != 0)
			return true;
		// Ici on est sur que l'année est divisible par 100
		// L'année est bisextile, si elle est divisible par 400
		return (annee % 400) == 0;
	}
}