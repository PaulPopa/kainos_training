package data;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.City;
import model.Country;

public interface WorldMapper {
	
	@Select("SELECT ID, Name, Population, District, CountryCode FROM city WHERE CountryCode = #{code}")
	List<City> getCitiesForCountry(@Param("code") String code);
	
	@Select("SELECT ID, Name, Population, CountryCode FROM city WHERE ID = #{id}")
	City getCity(@Param("id") int ID);
	
	@Select("SELECT Code, Name, Region, Continent FROM country WHERE Code='#{code}'")
	Country getCountry(@Param("code") String code);

	@Select("SELECT DISTINCT Continent FROM country ORDER BY 1")
	List<String> getContinents();
	
	@Select("SELECT DISTINCT Region, Continent FROM country WHERE Continent=#{continent} ORDER BY 1")
	List<String> getRegionsForContinent(@Param("continent") String continent);
	
	@Select("SELECT Code, Name, Region, Continent FROM country WHERE region=#{region} ORDER BY 2")
	List<Country> getCountriesForRegion(@Param("region") String region);
	
	@Select("SELECT ID, Name, Population, District, CountryCode FROM city WHERE District=#{district}")
	List<City> getCitiesForDistrict(@Param("district") String district);
	
	@Select("SELECT DISTINCT District FROM city WHERE CountryCode=#{countrycode} ORDER BY 1")
	List<String> getDistrictsForCountry(@Param("countrycode") String code);
	
	@Insert("INSERT INTO city(Name, CountryCode, District, Population) VALUES(#{name}, #{countryCode}, #{district}, #{population})")
	void insertCity(City city);	
}
