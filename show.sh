#!/bin/bash
lessc ~/installed/bootstrap-3.1.1/less/bootstrap.less > ~/projects/github/scamandrill/jekyll/assets/css/bootstrap.css
jekyll serve -s ~/projects/github/sbt-neo-dependencies/jekyll -d ~/projects/github/scamandrill/jekyll/_site