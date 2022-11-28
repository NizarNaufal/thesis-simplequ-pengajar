package com.example.thesis.utils

import com.example.thesis.utils.models.DatumModel

object DatumDummy {
    const val PASSWORD_PATTERN = "^[@#&-+()/?!;:'\"*~`|•√π÷×¶∆£¢€¥^°={}\\%©®™✓[]><∆#.0-9a-zA-Z\\s,_-]+\$]{6,25}"
    const val EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    fun generateDataMovieDummy(): List<DatumModel> {
        val listMovie = ArrayList<DatumModel>()

        listMovie.add(
            DatumModel(
                id = "SANTRI_1",
                name = "Delisa",
                desc = "10 Tahun",
                img_preview = "https://awsimages.detik.net.id/community/media/visual/2019/02/19/42393387-9c5c-4be4-97b8-49260708719e.jpeg?w=750&q=90"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_2",
                name = "Fahmi",
                desc = "5 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_3",
                name = "Ammar",
                desc = "15 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_4",
                name = "Naufal",
                desc = "6 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_5",
                name = "Nizar",
                desc = "7 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )
        return listMovie
    }

    fun generateDataPengajarDummy(): List<DatumModel> {
        val listMovie = ArrayList<DatumModel>()

        listMovie.add(
            DatumModel(
                id = "SANTRI_1",
                name = "Subadrun",
                desc = "50 Tahun",
                img_preview = "https://awsimages.detik.net.id/community/media/visual/2019/02/19/42393387-9c5c-4be4-97b8-49260708719e.jpeg?w=750&q=90"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_2",
                name = "Sukirman",
                desc = "51 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_3",
                name = "Boy",
                desc = "52 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/4IWnPqNu34zY4ku3LQJw56MIHFc.jpg"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_4",
                name = "Joko",
                desc = "53 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/xcaSYLBhmDzJ6P14bcKe0KTh3QV.jpgc"
            )
        )

        listMovie.add(
            DatumModel(
                id = "SANTRI_5",
                name = "Widodo",
                desc = "43 Tahun",
                img_preview = "https://image.tmdb.org/t/p/original/XAvFHWmWjBeJUQEHBbCcXvzdDZ.jpg"
            )
        )
        return listMovie
    }
}