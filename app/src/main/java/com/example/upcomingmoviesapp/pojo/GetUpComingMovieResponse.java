package com.example.upcomingmoviesapp.pojo;

public class GetUpComingMovieResponse
{
    private Dates dates;

    private String page;

    private String total_pages;

    private Results[] results;

    private String total_results;

    public Dates getDates ()
    {
        return dates;
    }

    public void setDates (Dates dates)
    {
        this.dates = dates;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getTotal_pages ()
    {
        return total_pages;
    }

    public void setTotal_pages (String total_pages)
    {
        this.total_pages = total_pages;
    }

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public String getTotal_results ()
    {
        return total_results;
    }

    public void setTotal_results (String total_results)
    {
        this.total_results = total_results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dates = "+dates+", page = "+page+", total_pages = "+total_pages+", results = "+results+", total_results = "+total_results+"]";
    }
    public class Dates
    {
        private String maximum;

        private String minimum;

        public String getMaximum ()
        {
            return maximum;
        }

        public void setMaximum (String maximum)
        {
            this.maximum = maximum;
        }

        public String getMinimum ()
        {
            return minimum;
        }

        public void setMinimum (String minimum)
        {
            this.minimum = minimum;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [maximum = "+maximum+", minimum = "+minimum+"]";
        }
    }
    public class Results
    {
        private String overview;

        private String original_language;

        private String original_title;

        private String video;

        private String title;

        private String[] genre_ids;

        private String poster_path;

        private String backdrop_path;

        private String release_date;

        private String vote_average;

        private String popularity;

        private String id;

        private String adult;

        private String vote_count;

        public String getOverview ()
        {
            return overview;
        }

        public void setOverview (String overview)
        {
            this.overview = overview;
        }

        public String getOriginal_language ()
        {
            return original_language;
        }

        public void setOriginal_language (String original_language)
        {
            this.original_language = original_language;
        }

        public String getOriginal_title ()
        {
            return original_title;
        }

        public void setOriginal_title (String original_title)
        {
            this.original_title = original_title;
        }

        public String getVideo ()
        {
            return video;
        }

        public void setVideo (String video)
        {
            this.video = video;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String[] getGenre_ids ()
        {
            return genre_ids;
        }

        public void setGenre_ids (String[] genre_ids)
        {
            this.genre_ids = genre_ids;
        }

        public String getPoster_path ()
        {
            return poster_path;
        }

        public void setPoster_path (String poster_path)
        {
            this.poster_path = poster_path;
        }

        public String getBackdrop_path ()
        {
            return backdrop_path;
        }

        public void setBackdrop_path (String backdrop_path)
        {
            this.backdrop_path = backdrop_path;
        }

        public String getRelease_date ()
        {
            return release_date;
        }

        public void setRelease_date (String release_date)
        {
            this.release_date = release_date;
        }

        public String getVote_average ()
        {
            return vote_average;
        }

        public void setVote_average (String vote_average)
        {
            this.vote_average = vote_average;
        }

        public String getPopularity ()
        {
            return popularity;
        }

        public void setPopularity (String popularity)
        {
            this.popularity = popularity;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getAdult ()
        {
            return adult;
        }

        public void setAdult (String adult)
        {
            this.adult = adult;
        }

        public String getVote_count ()
        {
            return vote_count;
        }

        public void setVote_count (String vote_count)
        {
            this.vote_count = vote_count;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [overview = "+overview+", original_language = "+original_language+", original_title = "+original_title+", video = "+video+", title = "+title+", genre_ids = "+genre_ids+", poster_path = "+poster_path+", backdrop_path = "+backdrop_path+", release_date = "+release_date+", vote_average = "+vote_average+", popularity = "+popularity+", id = "+id+", adult = "+adult+", vote_count = "+vote_count+"]";
        }
    }

}