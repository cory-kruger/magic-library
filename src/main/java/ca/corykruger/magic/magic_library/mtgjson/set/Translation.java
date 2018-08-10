package ca.corykruger.magic.magic_library.mtgjson.set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A wrapper for the non-English names of a set
 */
public class Translation {
	
	private String de;
	private String fr;
	private String it;
	private String es;
	private String pt;
	private String jp;
	private String cn;
	private String ru;
	private String tw;
	private String ko;
	
	/**
	 * Parameterized constructor
	 * @param de The German translation
	 * @param fr The French translation
	 * @param it The Italian translation
	 * @param es The Spanish translation
	 * @param pt The Portuguese translation
	 * @param jp The Japanese translation
	 * @param cn The Chinese (Simplified) translation
	 * @param ru The Russian translation
	 * @param tw The Chinese (Traditional) translation
	 * @param ko The Korean translation
	 */
	public Translation(String de, String fr, String it, String es, String pt, String jp, String cn, String ru,
			String tw, String ko) {
		this.de = de;
		this.fr = fr;
		this.it = it;
		this.es = es;
		this.pt = pt;
		this.jp = jp;
		this.cn = cn;
		this.ru = ru;
		this.tw = tw;
		this.ko = ko;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("German:  " + de + "\r\n");
		builder.append("French:  " + fr + "\r\n");
		builder.append("Italian:  " + it + "\r\n");
		builder.append("Spanish:  " + es + "\r\n");
		builder.append("Portuguese:  " + pt + "\r\n");
		builder.append("Japanese:  " + jp +  "\r\n");
		builder.append("Chinese (Simplified):  " + cn + "\r\n");
		builder.append("Russian:  " + ru + "\r\n");
		builder.append("Chinese (Traditional):  " + tw + "\r\n");
		builder.append("Korean:  " + ko + "\r\n");
		
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Translation) {
			Translation aTranslation = (Translation) obj;
			if (StringUtils.equals(this.de, aTranslation.getGerman())
					&& StringUtils.equals(this.fr, aTranslation.getFrench())
					&& StringUtils.equals(this.it, aTranslation.getItalian())
					&& StringUtils.equals(this.es, aTranslation.getSpanish())
					&& StringUtils.equals(this.pt, aTranslation.getPortuguese())
					&& StringUtils.equals(this.jp, aTranslation.getJapanese())
					&& StringUtils.equals(this.cn, aTranslation.getChineseSimplified())
					&& StringUtils.equals(this.ru, aTranslation.getRussian())
					&& StringUtils.equals(this.tw, aTranslation.getChineseTraditional())
					&& StringUtils.equals(this.ko, aTranslation.getKorean())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(37, 31)
				.append(this.de)
				.append(this.fr)
				.append(this.it)
				.append(this.es)
				.append(this.pt)
				.append(this.jp)
				.append(this.cn)
				.append(this.ru)
				.append(this.tw)
				.append(this.ko)
				.toHashCode();
	}
	
	public String getGerman() {
		return de;
	}
	
	public void setGerman(String german) {
		this.de = german;
	}
	
	public String getFrench() {
		return fr;
	}
	
	public void setFrench(String french) {
		this.fr = french;
	}
	
	public String getItalian() {
		return it;
	}
	
	public void setItalian(String italian) {
		this.it = italian;
	}
	
	public String getSpanish() {
		return es;
	}
	
	public void setSpanish(String spanish) {
		this.es = spanish;
	}
	
	public String getPortuguese() {
		return pt;
	}
	
	public void setPortuguese(String portuguese) {
		this.pt = portuguese;
	}
	
	public String getJapanese() {
		return jp;
	}
	
	public void setJapanese(String japanese) {
		this.jp = japanese;
	}
	
	public String getChineseSimplified() {
		return cn;
	}
	
	public void setChineseSimplified(String chineseSimplified) {
		this.cn = chineseSimplified;
	}
	
	public String getRussian() {
		return ru;
	}
	
	public void setRussian(String russian) {
		this.ru = russian;
	}
	
	public String getChineseTraditional() {
		return tw;
	}
	
	public void setChineseTraditional(String chinesetraditional) {
		this.tw = chinesetraditional;
	}
	
	public String getKorean() {
		return ko;
	}
	
	public void setKorean(String korean) {
		this.ko = korean;
	}
}
