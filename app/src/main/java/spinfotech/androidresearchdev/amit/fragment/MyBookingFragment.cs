
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Support.V4.Content;
using Android.Support.V7.Widget;
using Android.Util;
using Android.Views;
using Android.Widget;
using Motogari.Droid.Fragments;
using Motogari.Models;
using Motogari.Networking;
using Motogari.Droid.Adapters;


namespace Motogari.Droid.Activities
{
    public class MyBookingFragment : AbstractFragment
    {     
	TextView TxtViewPendingTab,TxtViewUpcomingTab,TxtViewCompletedTab;
    LinearLayout LinearLayoutMain;
	RecyclerView RecyclerViewBookings;
	List<MyBookingListModel> myBookingModelsList = new List<MyBookingListModel>();
    MyBookingPendingAdapter AdapterPending;
    MyBookingCompletedAdapter Adaptercompleted;
    

    DrawerActivity activity;

        public override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
        }

        public override View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
			View view = inflater.Inflate(Resource.Layout.fragment_my_bookings, null);
			activity = (DrawerActivity)this.Activity;
			ActvityInstance = (DrawerActivity)this.Activity;
			InitUi(view);
			SetListeners();
			return view; 
        }

		public void InitUi(View view)
		{
            TxtViewPendingTab = (TextView)view.FindViewById(Resource.Id.tvPendingTab);
            TxtViewUpcomingTab = (TextView)view.FindViewById(Resource.Id.tvUpcomingTab);
            TxtViewCompletedTab = (TextView)view.FindViewById(Resource.Id.tvCompletedTab);
            LinearLayoutMain =(LinearLayout)view.FindViewById(Resource.Id.llayout);
            RecyclerViewBookings = (RecyclerView)view.FindViewById(Resource.Id.recyclerViewDriverStatus);
            setTabListener(AppConstants.ROW_PENDING);
         
		}

		public void SetListeners()
		{
            TxtViewPendingTab.Click += OnPendingTabClick;
            TxtViewUpcomingTab.Click += OnUpcomingTabClick;
            TxtViewCompletedTab.Click += OnCompletedTabClick;
		}


        private void OnPendingTabClick(object obj,EventArgs e){
            setTabListener(AppConstants.ROW_PENDING);
        }

		private void OnUpcomingTabClick(object obj, EventArgs e)
		{
            setTabListener(AppConstants.ROW_UPCOMMING);
		}

		private void OnCompletedTabClick(object obj, EventArgs e)
		{
            setTabListener(AppConstants.ROW_COMPLETED);
		}


         

         

		private void setTabListener(int tabType)
		{
           // TxtViewPendingTab.SetBackgroundColor(Resources.GetColor(Resource.Color.color_white));

            LinearLayoutMain.SetBackgroundResource(Resource.Drawable.boarder_rect_black);

            TxtViewPendingTab.SetBackgroundColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_white)));   
           
            TxtViewPendingTab.SetTextColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_3d4246)));
		   
		  	 TxtViewUpcomingTab.SetBackgroundColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_white)));  
           
			TxtViewUpcomingTab.SetTextColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_3d4246)));
		  
		   	TxtViewCompletedTab.SetBackgroundColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_white)));
			 
			TxtViewCompletedTab.SetTextColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_3d4246))); 

            LinearLayoutMain.SetBackgroundResource(Resource.Drawable.boarder_rect_black);

			switch (tabType)
			{
                case AppConstants.ROW_PENDING:
                    myBookingModelsList.Clear();
                    if(AdapterPending!=null)
                    AdapterPending.NotifyDataSetChanged();
                    if (Adaptercompleted != null)
                    Adaptercompleted.NotifyDataSetChanged();
                    
                    callGetMyBookingListAPI(0);
					TxtViewPendingTab.SetBackgroundColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_3d4246)));
					TxtViewPendingTab.SetTextColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_white)));
					break;
				case AppConstants.ROW_UPCOMMING:
					myBookingModelsList.Clear();
					if (AdapterPending != null)
						AdapterPending.NotifyDataSetChanged();
					if (Adaptercompleted != null)
						Adaptercompleted.NotifyDataSetChanged();

					     callGetMyBookingListAPI(1);
				 
					TxtViewUpcomingTab.SetBackgroundColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_3d4246)));
					TxtViewUpcomingTab.SetTextColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_white)));
                     
					break;
				case AppConstants.ROW_COMPLETED:
					myBookingModelsList.Clear();
					if (AdapterPending != null)
						AdapterPending.NotifyDataSetChanged();
					if (Adaptercompleted != null)
						Adaptercompleted.NotifyDataSetChanged();
                    callGetMyBookingListAPI(2);
					TxtViewCompletedTab.SetBackgroundColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_3d4246)));
					TxtViewCompletedTab.SetTextColor(new Android.Graphics.Color(ContextCompat.GetColor(activity, Resource.Color.color_white)));
                     
					break;
			}
		}
         

		#region API Call Methods

		public void callGetMyBookingListAPI(int BookingTypeSelecetd)
		{

			ShowProgressDialog();

			MyBookingListAPICaller myBookingAPICaller = new MyBookingListAPICaller();

			var forBookingType = "";

			if (BookingTypeSelecetd == 0)
			{
				forBookingType = "PENDING";
			}
			else if (BookingTypeSelecetd == 1)
			{
				forBookingType = "UPCOMING";
			}
			else if (BookingTypeSelecetd == 2)
			{
				forBookingType = "COMPLETED";
			}

			myBookingAPICaller.CallGetMyBookingListAPI(forBookingType, myBookingModelsList.Count);

			myBookingAPICaller.OnMyBookingListAPIErrorResponse += (sender, e) => {
               
                DismissProgressDialog();
				MessageDialog dialog = new MessageDialog();
				dialog.SendMessage(e.Content, "Error");

				if (myBookingModelsList.Count == 0)
				{
					//MyBookingsTableView.Hidden = true;
				}
			};

			myBookingAPICaller.OnMyBookingListAPISuccessResponse += (sender, e) =>
			{

				List<MyBookingListModel> modelList = e.Content;

				this.myBookingModelsList.AddRange(modelList);

			//	MyBookingsTableView.Source = new MyBookingTableSource(this.myBookingModelsList, this.bookingTypeSelecetd);

				if (myBookingModelsList.Count == 0)
				{

				}
				else
				{
					var manager = new LinearLayoutManager(activity);
					RecyclerViewBookings.SetLayoutManager(manager);

                    if (BookingTypeSelecetd ==0){
                    AdapterPending = new MyBookingPendingAdapter(activity, myBookingModelsList);
                    RecyclerViewBookings.SetAdapter(AdapterPending);    
                    }else if(BookingTypeSelecetd==1){
						Adaptercompleted = new MyBookingCompletedAdapter(activity, myBookingModelsList, BookingTypeSelecetd);
						RecyclerViewBookings.SetAdapter(Adaptercompleted);
                    }else{
                        Adaptercompleted = new MyBookingCompletedAdapter(activity, myBookingModelsList,BookingTypeSelecetd);
                        RecyclerViewBookings.SetAdapter(Adaptercompleted);
					}
                     
				}

	DismissProgressDialog();
			};
		}

		#endregion
 
	}
}
